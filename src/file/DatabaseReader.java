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

    public Boolean database_exists(String dbname)
    {
        return true;

        //TODO implement the CSV reader here then leave a nice clean API
    }

    public Boolean table_exists(String dbname)
    {
        return true;

        //TODO implement the CSV reader here then leave a nice clean API
    }

    public Boolean verifydatabase(String sqlstring) throws Exception
    {
        return true;
    }

    public Boolean verify_table(String sqlstring) throws Exception
    {
        return true;
    }

    public static class FileUtility
    {

    }
}
