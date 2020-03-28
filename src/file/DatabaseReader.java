package file;

import parameter.Parameter;
import structures.database.DatabaseReference;
import structures.results.Result;

import java.io.File;
import java.util.HashMap;

public class DatabaseReader
{
    public File file;

    public DatabaseReference database;

    public DatabaseReader(DatabaseReference database)
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

    public Result select(Parameter parameter)
    {
        return new Result();
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
        //TODO write XML parser

        return null;
    }

    public static class FileUtility
    {

    }
}
