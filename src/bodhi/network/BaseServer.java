package bodhi.network;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class BaseServer extends Thread
{
    public ServerSocket serversocket;

    public Socket socket;

    public Connections connections = new Connections();

    public Integer port = 39001;

    public BaseServer(Integer port)
    {
        this.port = port;

        try
        {
            System.out.println(">> Server socket on port "+this.port+" initialized.");

            this.serversocket = new ServerSocket(this.port);
        }
        catch (Exception exception)
        {
            return;
        }

        this.start();
    }

    @Override
    public void run()
    {
        try
        {
            Socket socket;

            while(true)
            {
                this.connections.add(new Connection(this.serversocket.accept()));

                System.out.println("    >> Connection accepted from "+(this.connections.getLast().socket).getRemoteSocketAddress());
            }
        }
        catch(Exception e)
        {
            System.out.println(e);

            return;
        }
    }

    public static class Connections
    {
        public ArrayList<Connection> connections = new ArrayList<>(100);

        public void add(Connection connection)
        {
            this.connections.add(connection);
        }

        public Connection getFirst()
        {
            return this.connections.get(0);
        }

        public Connection getLast()
        {
            return this.connections.get(this.connections.size()-1);
        }
    }

    public static class Connection
    {
        public Socket socket;

        public Date date;

        public Connection(Socket socket)
        {
            this.socket = socket;

            this.date = new Date(System.currentTimeMillis());
        }
    }
}
