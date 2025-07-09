package bodhi.threads;

import bodhi.contexts.ConnectionContext;
import bodhi.network.RemoteBodhiServer;
import logging.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputPollingThread extends Thread
{
    public ConnectionContext context;

    public RemoteBodhiServer server;

    public ArrayList<String> inputBuffer = new ArrayList<>();


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
                    //putty telnet issue (client sends this string at initialization)
                    if(line.contains("��\u001F�� ��\u0018��'��\u0001��\u0003��\u0003"))
                    {
                        line = line.replace("��\u001F�� ��\u0018��'��\u0001��\u0003��\u0003","");

                        Logger.log(">> Putty detected; removing unnecessary string.", Logger.STDOUT, false);
                    }

                    this.inputBuffer.add(line);

                    Logger.log(">> "+this.context.connection.socket.toString()+" received: '"+line+"'", Logger.STDOUT, true);
                }

                this.server.interpreter.importMessages(this.inputBuffer);

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