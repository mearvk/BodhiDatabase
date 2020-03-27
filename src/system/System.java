package system;

import file.DatabaseReader;
import file.DatabaseWriter;
import parameter.Parameter;
import structures.database.Database;
import structures.database.handler.DatabaseHandler;

import java.util.HashMap;

public class System
{
    public Memory memory = new Memory();

    public static DatabaseHandler handler = new DatabaseHandler();

    public static class Memory
    {
        public static Memory reference = new Memory();

        protected HashMap<String, Object> map = new HashMap();

        public Memory()
        {
            Memory.reference = this;
        }

        public Object pull(String name)
        {
            return this.map.get(name);
        }

        public void push(String name, Object object)
        {
            this.map.put(name, object);
        }

        public Boolean exists(String name) throws Exception
        {
            boolean result = Memory.reference.pull(name)==null;

            if(result==true) throw new Exception();

            return false;
        }
    }

    public static Boolean die(String name) throws Exception
    {
        return Memory.reference.exists(name);
    }

    public static Boolean asset(String name) throws Exception
    {
        return Memory.reference.exists(name);
    }

    public static Object pull(String name)
    {
        return Memory.reference.pull(name);
    }

    public static void push(String name, Object object)
    {
        Memory.reference.push(name, object);
    }

    public static class DatabaseHandler
    {
        public static DatabaseHandler reference = new DatabaseHandler();

        public Database database;

        public DatabaseWriter writer;

        public DatabaseReader reader;

        public DatabaseHandler()
        {
            Database database = (Database)System.pull("//database");

            this.writer = new DatabaseWriter(database);

            this.reader = new DatabaseReader(database);
        }

        protected boolean integrity()
        {
            //TODO reader checks integrity

            return true;
        }

        public DatabaseHandler table_exists(Parameter parameter)
        {
            return this;
        }

        public DatabaseHandler database_exists(Parameter parameter)
        {
            return this;
        }

        public DatabaseHandler createTable(Parameter parameter)
        {
            return this;
        }

        public DatabaseHandler verifyTable(Parameter parameter)
        {
            return this;
        }
    }

}
