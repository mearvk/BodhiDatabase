package contexts;

import bodhi.interpreter.Interpreter;
import bodhi.network.BaseServer;
import bodhi.network.RemoteBodhiServer;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class ConnectionContext extends Thread
{
    public BaseServer.Connection connection;

    public RemoteBodhiServer server;

    public Date timestamp;

    public ConnectionContext(BaseServer.Connection connection, RemoteBodhiServer server, Date timestamp)
    {
        this.connection = connection;

        this.server = server;

        this.timestamp = timestamp;
    }

    @Override
    public void run()
    {
        //check for new connections with waiting data presumably
    }

    public static class InputThread extends Thread
    {
        public RemoteBodhiServer server;

        public ArrayList<String> inputBuffer = new ArrayList<>();

        public InputStream inputStream;

        public Interpreter interpreter = new Interpreter(this);

        public InputThread(RemoteBodhiServer server)
        {
            this.server = server;
        }

        @Override
        public void run()
        {
            while(true)
            {
                try
                {
                    this.inputStream = this.server.socket.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(this.inputStream));

                    String line = null;

                    while((line=reader.readLine())!=null)
                    {
                        this.inputBuffer.add(line);
                    }

                    this.interpreter.copyBuffer(this.inputBuffer);

                    Thread.sleep(20);
                }
                catch (NullPointerException npe)
                {
                    return;
                }
                catch (Exception e)
                {
                    System.out.println(e);

                    return;
                }
            }
        }
    }

    public static class OutputThread extends Thread
    {
        public RemoteBodhiServer server;

        public OutputStream outputStream;

        public ArrayList<String> outputBuffer = new ArrayList<>(100);

        public OutputThread(RemoteBodhiServer server)
        {
            this.server = server;
        }

        @Override
        public void run()
        {
            while(true)
            {
                if(this.outputBuffer.size()==0)
                {
                    try
                    {
                        Thread.sleep(20);
                    }
                    catch (Exception e)
                    {
                        return;
                    }
                }
                else
                {
                    String line = this.outputBuffer.remove(0);

                    try
                    {
                        this.outputStream = this.server.socket.getOutputStream();

                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(this.outputStream));

                        writer.write(line);

                        writer.flush();
                    }
                    catch (IOException e)
                    {
                        return;
                    }
                }
            }
        }
    }
}