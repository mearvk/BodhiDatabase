package database;

import java.util.HashMap;

public class SQLTable
{
    public String name;

    public SQLColumn column;

    public List columns = new List();

    public SQLTable(String name)
    {
        this.name = name;
    }

    public static class List
    {
        public HashMap<String, SQLColumn> items = new HashMap<>();

        public SQLColumn get(String name)
        {
            return items.get(name);
        }

        public void put(SQLColumn column)
        {
            this.items.put(column.name,column);
        }
    }
}
