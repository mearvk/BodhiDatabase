package components.database;

import components.database.handler.DatabaseHandler;
import constants.DatabaseConstants;

import java.io.File;

public class Database
{
    public String location;

    public Database database;

    public File file;

    public DatabaseHandler handler;

    public Database(String name)
    {
        this.location = DatabaseConstants.baseURL+"\\"+name+".sql";
    }

    public Database(String name, String absolute_location)
    {
        this.location = absolute_location +"\\"+ name +".sql";
    }

    public Database(File file)
    {
        this.file = file;
    }

    public Database(Database database)
    {
        this.database = database;
    }
}
