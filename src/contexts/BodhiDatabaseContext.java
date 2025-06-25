package contexts;

import bodhi.BodhiDatabase;

public class BodhiDatabaseContext extends DatabaseContext
{
    public BodhiDatabase database;


    public BodhiDatabaseContext(String name)
    {

    }

    public BodhiDatabaseContext(String name, BodhiDatabase database)
    {
        this.database = database;
    }
}
