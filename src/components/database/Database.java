package components.database;

import components.database.handler.DatabaseHandler;

import java.io.File;

public class Database
{
    public String name;

    public String location;

    public static Database database;

    public File file;

    public DatabaseHandler handler;

    public Database(String name, File file)
    {
        this.file = file;

        this.name = name;
    }
}
