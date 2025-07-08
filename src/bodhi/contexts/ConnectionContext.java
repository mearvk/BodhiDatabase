package bodhi.contexts;

import bodhi.interpreter.Interpreter;
import bodhi.network.RemoteBodhiServer;
import bodhi.connections.Connection;
import logging.Logger;

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

        public Interpreter interpreter = new Interpreter();

        public InputPollingThread(ConnectionContext context)
        {
            this.context = context;

            this.interpreter.context = context;

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
                        //putty telnet issue (client sends this string at initialization)
                        if(line.contains("��\u001F�� ��\u0018��'��\u0001��\u0003��\u0003"))
                        {
                            line = line.replace("��\u001F�� ��\u0018��'��\u0001��\u0003��\u0003","");

                            Logger.log(">> Putty Client detected; removing unnecessary string.", Logger.STDOUT, false);
                        }

                        this.inputBuffer.add(line);

                        Logger.log(">> "+this.context.connection.socket.toString()+" received: "+line, Logger.STDOUT, true);
                    }

                    this.interpreter.importMessages(this.inputBuffer);

                    Thread.sleep(20);
                }
                catch (NullPointerException npe)
                {
                    Logger.log(npe.getMessage(), npe, Logger.STDOUT, true);

                    return;
                }
                catch (Exception e)
                {
                    Logger.log(e.getMessage(), e, Logger.STDOUT, true);

                    return;
                }
            }
        }
    }

    public static class OutputPollingThread extends Thread
    {
        public ConnectionContext context;

        public RemoteBodhiServer server;

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
                        Logger.log(">> "+e.getMessage(), e, Logger.STDOUT, true);

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
                        Logger.log(">> "+e.getMessage(), e, Logger.STDOUT, true);

                        return;
                    }
                }
            }
        }
    }
}