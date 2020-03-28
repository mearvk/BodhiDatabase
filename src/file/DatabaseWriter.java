package file;

import parameter.Parameter;
import structures.database.DatabaseReference;

public class DatabaseWriter
{
    public DatabaseReference database;

    public Parameter parameter;

    public static final Integer TABLE = 0;

    public static final Integer DATABASE = 1;

    public DatabaseWriter(DatabaseReference database)
    {
        this.database = database;
    }

    public DatabaseWriter(Parameter parameter)
    {
        this.parameter = parameter;
    }

    public Boolean table_not_exists(String tablename)
    {
        return true;
    }

    public DatabaseWriter tablewriter(Parameter parameter)
    {
        return this;
    }

    public DatabaseWriter insert_into(Parameter parameter)
    {
        return this;
    }

    public DatabaseWriter verify_table(Parameter parameter)
    {
        return this;
    }

    public DatabaseWriter drop_database(Parameter parameter)
    {
        return this;
    }

    public DatabaseWriter drop_columns(Parameter parameter)
    {
        return this;
    }

    public DatabaseWriter write_columns(String tablename)
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
