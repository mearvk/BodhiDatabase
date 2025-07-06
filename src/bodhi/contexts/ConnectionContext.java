package bodhi.contexts;

import bodhi.interpreter.Interpreter;
import bodhi.network.RemoteBodhiServer;
import bodhi.connections.Connection;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class ConnectionContext
{
    public Connection connection;

    public RemoteBodhiServer server;

    public Date timestamp;

    public InputPollingThread input;

    public OutputPollingThread output;

    public ConnectionContext(Connection connection, RemoteBodhiServer server, Date timestamp)
    {
        this.connection = connection;

        this.server = server;

        this.timestamp = timestamp;

        this.input = new InputPollingThread(this);

        this.output = new OutputPollingThread(this);

        //

        this.input.start();

        this.output.start();
    }

    public static class InputPollingThread extends Thread
    {
        public ConnectionContext context;

        public RemoteBodhiServer server;

        public ArrayList<String> inputBuffer = new ArrayList<>();

        public InputStream inputStream;

        public Interpreter interpreter = new Interpreter(this);

        public InputPollingThread(ConnectionContext context)
        {
            this.context = context;

            this.server = context.server;
        }

        @Override
        public void run()
        {
            while(true)
            {
                try
                {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(this.context.connection.socket.getInputStream()));

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

    public static class OutputPollingThread extends Thread
    {
        public ConnectionContext context;

        public RemoteBodhiServer server;

        public OutputStream outputStream;

        public ArrayList<String> outputBuffer = new ArrayList<>(100);

        public OutputPollingThread(ConnectionContext context)
        {
            this.context = context;

            this.server = context.server;
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
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(this.context.connection.socket.getOutputStream()));

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