package file;

import components.database.Database;

public class DatabaseWriter
{
    public Database database;

    public DatabaseWriter(Database database)
    {
        this.database = database;
    }

    public Boolean table_exists(String tablename)
    {
        return true;
    }

    public DatabaseWriter create_table(String tablename)
    {
        return this;
    }

    public DatabaseWriter writeColumns(String tablename)
    {
        return this;
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
