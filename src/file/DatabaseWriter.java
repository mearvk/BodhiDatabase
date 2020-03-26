package file;

import components.database.Database;

public class DatabaseWriter
{
    public Database database;

    public DatabaseWriter(Database database)
    {
        this.database = database;
    }

    public Boolean tableExists(String tablename)
    {
        return true;
    }

    public Boolean createTable(String tablename)
    {
        return true;
    }

    public DatabaseWriter flush()
    {
        return this;
    }

    public DatabaseWriter close()
    {
        return this;
    }
}
