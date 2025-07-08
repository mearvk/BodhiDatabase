package bodhi.network;

import bodhi.interpreter.Interpreter;
import bodhi.listener.ConnectionListener;
import bodhi.contexts.ConnectionContext;
import bodhi.contexts.BodhiDatabaseContext;
import bodhi.BodhiDatabase;
import bodhi.contexts.DatabaseContext;

import java.util.ArrayList;

public class RemoteBodhiServer extends BaseServer
{
    public static final Integer PORT = 39001;

    public DatabaseContext context;

    public BodhiDatabase database;

    public ArrayList<ConnectionContext> contexts = new ArrayList<>(100);

    public ConnectionListener listener = new ConnectionListener(this);

    public Interpreter interpreter;

    public RemoteBodhiServer()
    {
        super(PORT);
    }

    public RemoteBodhiServer(BodhiDatabaseContext context)
    {
        super(PORT);

        //

        this.context = context;

        this.database = context.database;

        //

        this.listener.start();
    }
}
