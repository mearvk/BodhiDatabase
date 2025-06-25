package database;

import java.util.HashMap;

public class SQLDatabase
{
    public String name;

    public HashMap<String, SQLTable> tables = new HashMap<>();
    public SQLDatabase(String name)
    {
        this.name = name;
    }

    public SQLResult insert(SQLTable table, SQLColumn column, Object object)
    {
        if(table==null)
        {
            SQLResult result;

            result = new SQLResult();

            result.error = "Table is unexpectedly null.";

            return result;
        }

        //

        if(column==null)
        {
            SQLResult result;

            result = new SQLResult();

            result.error = "Column is unexpectedly null.";

            return result;
        }

        //

        column.items.add(object);

        //

        SQLResult result = new SQLResult();

        result.database = this;

        result.table = table;

        result.table.column = column;

        result.table.column.object = object;

        //

        return result;
    }

    public SQLResult insert(SQLTable table)
    {
        this.tables.put(table.name, table);

        SQLResult result = new SQLResult();

        result.database = this;

        result.table = table;

        return result;
    }

    public SQLResult insert(SQLTable table, SQLColumn column)
    {
        table.columns.put(column);

        SQLResult result = new SQLResult();

        result.database = this;

        result.table = table;

        result.column = column;

        return result;
    }
}
