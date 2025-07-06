package bodhi.connections;

import java.net.Socket;
import java.util.Date;

public class Connection
{
    public Socket socket;

    public Date date;

    public Connection(Socket socket)
    {
        this.socket = socket;

        this.date = new Date(System.currentTimeMillis());
    }
}
