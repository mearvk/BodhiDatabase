package bodhi;

import contexts.BodhiDatabaseContext;
import database.SQLColumn;
import database.SQLDatabase;
import database.SQLResult;
import database.SQLTable;

import java.util.HashMap;

public class BodhiDatabase
{
    public HashMap<String, SQLDatabase> databases = new HashMap<>();

    public BodhiDatabaseContext context;

    public BodhiDatabase()
    {

    }

    public BodhiDatabase(SQLDatabase database, BodhiDatabaseContext context)
    {
        this.databases.put(database.name, database);

        this.context = context;
    }

    public SQLDatabase getDatabase(String name)
    {
        return this.databases.get(name);
    }

    public void addDatabase(SQLDatabase database)
    {
        this.databases.put(database.name, database);
    }

    public SQLResult insert(String databasename, String tablename, String columnname, Object object)
    {
        SQLResult result = new SQLResult();

        //

        SQLDatabase database = this.databases.get(databasename);

        if(database==null)
        {
            result.error = "No such database.";

            return result;
        }

        //

        SQLTable table = database.tables.get(tablename);

        if(table==null)
        {
            result.error = "No such table name.";

            return result;
        }

        //

        SQLColumn column = table.columns.get(columnname);

        if(column==null)
        {
            result.error = "No such column name.";

            return result;
        }

        result = database.insert(table, column, object);

        return result;
    }

    public SQLResult insert(String databasename, SQLTable table)
    {
        SQLResult result = new SQLResult();

        //

        SQLDatabase database = this.databases.get(databasename);

        if(database==null)
        {
            result.error = "Database not found.";

            return result;
        }

        //

        result = database.insert(table);

        return result;
    }

    public SQLResult insert(String databasename, String tablename, SQLColumn column)
    {
        SQLResult result = new SQLResult();

        //

        SQLDatabase database = this.databases.get(databasename);

        if(database==null)
        {
            result.error = "";

            return result;
        }

        //

        SQLTable table = database.tables.get(tablename);

        if(table==null)
        {
            result.error = "";

            return result;
        }

        //

        result = database.insert(table, column);

        //

        result.database = database;

        result.table = table;

        result.column = column;

        return result;
    }
}
