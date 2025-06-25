package database;

import java.util.ArrayList;

public class SQLColumn
{
    public String name;

    public List items;

    public Object object;

    public SQLColumn(String name)
    {
        this.name = name;

        this.items = new List(this.name);
    }

    public static class List
    {
        public String name;

        public ArrayList<Object> items;

        public List(String name)
        {
            this.name = name;

            this.items = new ArrayList<>(10);
        }

        public void add(Object object)
        {
            this.items.add(object);
        }
    }
}
