package components.database;

import structures.database.handler.DatabaseHandler;
import parameter.Parameter;

import java.io.File;

public class Database
{
    public String name;

    public String sqlstring;

    public static Database database;

    public File file;

    public DatabaseHandler handler;

    public Database(Parameter parameter)
    {
        this.file = parameter.database_file;

        this.name = parameter.database_name;

        //this.handler = new DatabaseHandler();
    }

    public Database(String sqlstring)
    {
        this.sqlstring = sqlstring;
    }
}
