package bodhi.network;

import java.net.ServerSocket;
import java.net.Socket;

public class BaseServer implements Runnable
{
    public ServerSocket serversocket;

    public Socket socket;

    public Integer port = 0;

    public BaseServer()
    {

    }

    public BaseServer(Integer port)
    {
        this.port = port;
    }

    @Override
    public void run()
    {
        try
        {
            if(this.port==0)
            {
                this.serversocket = new ServerSocket(39001);

                this.socket = this.serversocket.accept();
            }
            else
            {
                this.serversocket = new ServerSocket(this.port);

                this.socket = this.serversocket.accept();
            }
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
