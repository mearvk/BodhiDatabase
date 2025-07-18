package bodhi.listener;

import bodhi.connections.Connection;
import bodhi.network.RemoteBodhiServer;
import bodhi.contexts.ConnectionContext;
import logging.Logger;

import java.util.Date;

public class ConnectionListener extends Thread
{
    public RemoteBodhiServer server;

    public ConnectionListener(RemoteBodhiServer server)
    {
        this.server = server;
    }

    @Override
    public void run()
    {
        while(true)
        {
            Connection connection = this.server.connections.getFirst();

            if(connection==null)
            {
                try
                {
                    Thread.sleep(20);
                }
                catch (Exception e)
                {
                    Logger.log(e.getMessage(), e, Logger.STDOUT, true);
                 }
            }
            else
            {
                this.server.contexts.add(new ConnectionContext(connection, this.server, new Date(System.currentTimeMillis())));
            }
        }
    }
}