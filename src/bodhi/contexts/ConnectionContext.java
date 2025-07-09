package bodhi.contexts;

import bodhi.network.RemoteBodhiServer;
import bodhi.connections.Connection;
import bodhi.threads.InputPollingThread;
import bodhi.threads.OutputPollingThread;

import java.util.Date;

public class ConnectionContext
{
    public Connection connection;

    public RemoteBodhiServer server;

    public Date start;
    
    public Date stop;

    public InputPollingThread input;

    public OutputPollingThread output;

    public ConnectionContext(Connection connection, RemoteBodhiServer server, Date start)
    {
        this.connection = connection;

        this.server = server;

        this.start = start;

        this.input = new InputPollingThread(this);

        this.output = new OutputPollingThread(this);

        //

        this.input.start();

        this.output.start();
    }
}