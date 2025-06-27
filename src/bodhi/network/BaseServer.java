package bodhi.network;

import java.net.ServerSocket;
import java.net.Socket;

public class BaseServer
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

        try
        {
            if(this.port==0)
            {
                this.serversocket = new ServerSocket(39001);

            }
            else
            {
                this.serversocket = new ServerSocket(this.port);
            }

            this.socket = this.serversocket.accept();
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
