package system;

import cases.UseImpl;
import components.memory.Memory;
import components.persistence.PersistenceComponent;
import components.processor.ProcessorComponent;
import constants.DatabaseConstants;
import contexts.CreateDatabaseImplContext;
import contexts.UseImplContext;
import file.DatabaseReader;
import file.DatabaseWriter;
import parameter.Parameter;
import structures.SQLString;
import structures.database.DatabaseReference;
import components.validation.ValidationComponent;

public class System
{
    public static System reference;

    public static Memory memory = new Memory();

    public static DatabaseHandler database = new DatabaseHandler();

    public static ValidationComponent validation = new ValidationComponent();

    public static ProcessorComponent processor = new ProcessorComponent();

    public System()
    {
        System.reference = this;
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

    public static void set(String property, String ref, Class klass) throws Exception
    {
        if(property.equals("//database/selected")  && klass.isAssignableFrom(UseImplContext.class))
        {
            System.push(property, ref);
        }
    }

    public static void set(String bodhi, Parameter parameter, Class<?> klass) throws Exception
    {
        if(bodhi.equals("//database") && klass.isAssignableFrom(UseImplContext.class))
        {
            System.push(bodhi, "//database");
        }

        if(bodhi.equals("//database/selected")  && klass.isAssignableFrom(UseImplContext.class))
        {
            System.push(bodhi, "//database");
        }

        if(bodhi.equals("//database/properties/name") && klass.isAssignableFrom(UseImplContext.class))
        {
            System.push(bodhi, UseImpl.Utility.getDatabaseName(parameter));
        }

        if(bodhi.equals("//database/properties/file") && klass.isAssignableFrom(UseImplContext.class))
        {
            String name = parameter.name = (String)System.pull("//database/properties/name");

            System.push(bodhi, UseImpl.Utility.getDatabaseFile(parameter));
        }
    }

    public static Boolean tattle(String name) throws Exception
    {
        return Memory.reference.exists(name);
    }

    public static Boolean tprint(String name) throws Exception
    {
        if(name.equals("//database/selected"))
        {
            java.lang.System.out.println("Database <"+(String)System.pull("//database/properties/name")+"> selected.");
        }

        return Memory.reference.exists(name);
    }

    public static Boolean tattle(String...names) throws Exception
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
        ValidationComponent.reference.push(name, klass);
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

    public static void push(String name, String target)
    {
        Memory.reference.push(name, target);
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
