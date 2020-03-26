package file;

import components.database.Database;

import java.io.File;

public class DatabaseReader
{
    public File file;

    public Database database;

    public DatabaseReader(Database database)
    {
        this.database = database;
    }

    public Boolean databaseExists(String dbname)
    {
        return true;

        //TODO implement the CSV reader here then leave a nice clean API
    }

    public static class FileUtility
    {

    }
}
