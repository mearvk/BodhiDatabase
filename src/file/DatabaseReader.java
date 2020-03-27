package file;

import components.database.Database;

import java.io.File;
import java.util.HashMap;

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

    public Boolean verify_database(String sqlstring) throws Exception
    {
        return true;
    }

    public Boolean verify_table(String sqlstring) throws Exception
    {
        return true;
    }

    public Boolean table_not_exists(String tablename)
    {
        return true;
    }

    public HashMap<String, String> get_columns()
    {
        if(this.database.sqlstring==null) return null;

        //TODO write XML parser

        return null;
    }

    public static class FileUtility
    {

    }
}
