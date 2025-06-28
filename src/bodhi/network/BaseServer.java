package bodhi.network;

import java.net.ServerSocket;
import java.net.Socket;

public class BaseServer extends Thread
{
    public ServerSocket serversocket;

    public Socket socket;

    public Integer port = 0;

    public BaseServer(Integer port)
    {
        this.port = port;

        try
        {
            if(this.port==0)
            {
                System.out.println("<Opening Server Socket on port 39001>");

                this.serversocket = new ServerSocket(39001);
            }
            else
            {
                System.out.println("<Opening Server Socket on port "+this.port+">");

                this.serversocket = new ServerSocket(this.port);
            }
        }
        catch (Exception exception)
        {
            return;
        }

        this.start();

        //this.run();
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println("<ServerSocket set to accept>");

            this.socket = this.serversocket.accept();

            System.out.println("<Connection accepted from "+socket.getRemoteSocketAddress()+">");
        }
        catch(Exception e)
        {
            System.out.println(e);

            return;
        }
    }

}
