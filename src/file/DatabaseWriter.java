package file;

import components.database.Database;
import parameter.Parameter;

public class DatabaseWriter
{
    public Database database;

    public static final Integer TABLE = 0;

    public static final Integer DATABASE = 1;

    public DatabaseWriter(Database database)
    {
        this.database = database;
    }

    public Boolean table_not_exists(String tablename)
    {
        return true;
    }

    public DatabaseWriter write(Parameter parameter, Integer type)
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
