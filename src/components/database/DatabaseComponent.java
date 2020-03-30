package components.database;

import components.Component;
import structures.SQLString;
import system.System;

import java.util.LinkedList;

public class DatabaseComponent extends Component
{
    public DatabaseComponent.Reference reference = new Reference();

    public DatabaseComponent.Properties properties = new Properties();

    //public ThreadImplementation thread = new ThreadImplementation();

    public LinkedList<SQLString> queue = new LinkedList<SQLString>();

    public DatabaseComponent() throws Exception
    {
        System.push("//database", this);

        System.push("//database/queue", this.queue);

        System.push("//database/properties", this.properties);
    }

    public static class Properties
    {
        public String name;

        public String file;
    }

    public static class Reference
    {

    }
}
