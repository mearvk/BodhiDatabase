package system;

import cases.UseImpl;
import components.persistence.PersistenceComponent;
import context.Context;
import context.UseImplContext;
import file.DatabaseReader;
import file.DatabaseWriter;
import parameter.Parameter;
import structures.SQLString;
import structures.database.DatabaseReference;
import utility.validation.Validation;
import utility.validation.ValidationHandler;

import java.util.HashMap;

public class System
{
    public Memory memory = new Memory();

    public static DatabaseHandler database = new DatabaseHandler();

    public static ValidationHandler validation = new ValidationHandler();

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

        public Boolean non_null(String name)
        {
            return Memory.reference.pull(name)==null;
        }

        public Boolean exists(String name) throws Exception
        {
            boolean result = Memory.reference.pull(name)==null;

            if(result==true) throw new Exception();

            return false;
        }

        public Boolean exists(String name, String exception) throws Exception
        {
            boolean result = Memory.reference.pull(name)==null;

            if(result==true) throw new Exception(exception);

            return false;
        }
    }

    public static void persist(Parameter parameter)
    {
        PersistenceComponent persistenceComponent = (PersistenceComponent)System.pull("//persistence");

        persistenceComponent.queue.add(new SQLString(parameter.sqlstring));
    }

    public static Boolean non_null(String name, String exception)
    {
        return Memory.reference.non_null(name);
    }

    public static void set(String string, Parameter parameter, Context context) throws Exception
    {
        if(string.equals("//parameter/name") && context instanceof UseImplContext)
        {
            parameter.name = UseImpl.Utility.getDatabaseName(parameter);
        }
        if(string.equals("//parameter/file"))
        {
            parameter.file = UseImpl.Utility.getDatabaseFile(parameter);
        }
    }

    public static Boolean touch(String name) throws Exception
    {
        return Memory.reference.exists(name);
    }

    public static Boolean touch(String...names) throws Exception
    {
        Boolean result = true;

        for(String name : names)
        {
            result = Memory.reference.exists(name) & result;
        }

        return result;
    }

    public static void validate(String name, Class<?> klass) throws Exception
    {
        Validation.reference.push(name, klass);
    }

    public static void print(String value) throws Exception
    {
        java.lang.System.out.print(value);
    }

    public static void println(String value) throws Exception
    {
        java.lang.System.out.println(value);
    }

    public static Boolean put(String name) throws Exception
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

    public static Object validate(String name)
    {
        return Memory.reference.pull(name);
    }

    public static class DatabaseHandler
    {
        public static DatabaseHandler reference = new DatabaseHandler();

        public DatabaseReference database;

        public DatabaseWriter writer;

        public DatabaseReader reader;

        public DatabaseHandler()
        {
            DatabaseReference database = (DatabaseReference)System.pull("//database");

            this.writer = new DatabaseWriter(database);

            this.reader = new DatabaseReader(database);
        }

        protected boolean integrity()
        {
            //TODO reader checks integrity

            return true;
        }

        public DatabaseHandler delete_from(Parameter parameter)
        {
            return this;
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
