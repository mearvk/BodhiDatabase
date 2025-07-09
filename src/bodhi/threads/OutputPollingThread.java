package bodhi.threads;

import bodhi.contexts.ConnectionContext;
import bodhi.network.RemoteBodhiServer;
import logging.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class OutputPollingThread extends Thread
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