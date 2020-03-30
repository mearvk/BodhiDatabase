package components.database;

import components.Component;
import structures.SQLString;
import system.System;

import java.util.LinkedList;

public class Database extends Component
{
    public Database.Properties properties = new Properties();

    public LinkedList<SQLString> queue = new LinkedList<SQLString>();

    public Database() throws Exception
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
