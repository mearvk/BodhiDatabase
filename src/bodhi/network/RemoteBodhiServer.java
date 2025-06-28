package bodhi.network;

import contexts.BodhiDatabaseContext;
import bodhi.BodhiDatabase;
import contexts.DatabaseContext;
import interpreter.SQLInterpreter;

import java.io.*;
import java.util.ArrayList;

public class RemoteBodhiServer extends BaseServer
{
    public static final Integer PORT = 39001;

    public DatabaseContext context;

    public OutputThread outputthread;

    public InputThread inputThread;

    public BodhiDatabase database;

    public RemoteBodhiServer()
    {
        super(PORT);
    }

    public RemoteBodhiServer(BodhiDatabaseContext context)
    {
        super(PORT);

        this.context = context;

        this.database = context.database;

        this.outputthread = new OutputThread(this);

        this.inputThread = new InputThread(this);

        this.context.inputStream = inputThread.inputStream;

        this.context.outputStream = outputthread.outputStream;

        this.outputthread.start();

        this.inputThread.start();
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

    public static class InputThread extends Thread
    {
        public RemoteBodhiServer server;

        public ArrayList<String> inputBuffer = new ArrayList<>();

        public InputStream inputStream;

        public InputInterpreter interpreter = new InputInterpreter(this);

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

    public static class InputInterpreter extends Thread
    {
        public RemoteBodhiServer server;

        public BodhiDatabase database;

        public InputThread inputthread;

        public ArrayList<String> buffer = new ArrayList<>();

        public SQLInterpreter interpreter;

        public void copyBuffer(ArrayList<String> buffer)
        {
            this.buffer.addAll(buffer);
        }

        public InputInterpreter(InputThread inputthread)
        {
            this.inputthread = inputthread;

            this.server = inputthread.server;

            this.interpreter = new SQLInterpreter(this.database);
        }

        @Override
        public void run()
        {
            while(true)
            {
                if(this.buffer.isEmpty())
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
                    String line = this.buffer.remove(0).strip();

                    this.interpreter.interpret(line);
                }
            }
        }
    }
}
