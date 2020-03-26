package components.database;

import components.database.handler.DatabaseHandler;
import parameter.Parameter;

import java.io.File;

public class Database
{
    public String name;

    public String location;

    public static Database database;

    public File file;

    public DatabaseHandler handler;

    public Database(Parameter parameter)
    {
        this.file = parameter.file;

        this.name = parameter.databasename;
    }
}
