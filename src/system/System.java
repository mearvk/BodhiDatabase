package system;

import cases.CreateDatabaseImpl;
import cases.CreateTableImpl;
import cases.UseDatabaseImpl;

import structures.table.Table;
import structures.database.Database;

import components.memory.Memory;
import components.persistence.Persistence;
import components.processor.Processor;
import components.validation.ValidationComponent;

import messaging.MessageQueue;

import parameter.Parameter;

import io.Reader;

public class System
{
    public static System reference;

    public static Memory memory = new Memory();

    public static Processor processor;

    private Database database;

    //

    public System() throws Exception
    {
        System.reference = this;

        System.processor = new Processor();
    }

    //

    public static void pre(final String bodhi) throws Exception
    {
        if(bodhi.equals("//continue"))
        {
            System.storage(bodhi, true);
        }
    }

    public static void writer(final String bodhi, final structures.database.Database database, Parameter parameter, Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();

        persistence.writer.writeXML(bodhi, database, parameter, context);
    }

    public static void writer(final String bodhi, final structures.database.Database database, structures.table.Table table, Parameter parameter, Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();

        persistence.writer.writeXML(bodhi, database, table, parameter, context);
    }

    public static void unset(final String bodhi) throws Exception
    {
        if(bodhi.equals("//continue"))
        {
            System.invalidate(bodhi);
        }
    }

    public static void stepper(final String property, final String ref, Class klass) throws Exception
    {
        if(property.equals("//database/selected")  && klass.isAssignableFrom(UseDatabaseImpl.class))
        {
            System.storage(property, ref);
        }
    }

    public static Object finalize(final String bodhi, final String memory, final Class<?> context) throws Exception
    {
        return System.reference;
    }

    public static Object finalize(final String bodhi, final Parameter parameter, final Class<?> context) throws Exception
    {
        if(bodhi.equals("//spin{database}") && context.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
        {
            Database database = (Database)System.peek("//database");

            System.equality("//database{exists}", database.exists);

            System.equality("//database{name}", database.name);

            System.equality("//database{url}", database.url);

            return System.reference;
        }

        else if(bodhi.equals("//spin{database}") && context.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
        {
            Database database;

            database = (Database)System.peek("//database");

            if(database==null)
            {
                System.storage("//database", database = new Database(parameter,context));
            }

            Persistence persistence;

            persistence = new Persistence();

            persistence.writer.writeXML(bodhi, database, null, parameter, context);
        }

        else if(bodhi.equals("//spin{database}") && context.isAssignableFrom(CreateDatabaseImpl.PostconditionCheck.class))
        {
            Database database;

            database = (Database)System.peek("//database");

            if(database==null)
            {
                System.storage("//database", database = new Database(parameter,context));
            }

            Reader reader;

            reader = new Reader();

            reader.checkXML(bodhi, database, parameter, context);
        }

        //

        else if(bodhi.equals("//spin{database}") && context.isAssignableFrom(UseDatabaseImpl.PreconditionCheck.class))
        {
            Database database;

            database = (Database)System.storage("//database");

            //

            System.full("//database{name}");

            System.full("//database{url}");

            //

            database.name = (String)System.storage("//database{name}");

            database.url = (String)System.storage("//database{url}");
        }

        else if(bodhi.equals("//spin{database}") && context.isAssignableFrom(UseDatabaseImpl.TaskRunner.class))
        {
            Database database;

            database = (Database)System.storage("//database");

            //

            System.equality(database.name,"//database{name}", UseDatabaseImpl.TaskRunner.class);

            System.equality(database.url, "//database{url}", UseDatabaseImpl.TaskRunner.class);

            //

            System.utility("//database", parameter, UseDatabaseImpl.TaskRunner.class);
        }

        else if(bodhi.equals("//spin{database}") && context.isAssignableFrom(UseDatabaseImpl.PostconditionCheck.class))
        {
            Database database;

            database = (Database)System.storage("//database");

            //

            System.equality(database.name,"//database{name}", UseDatabaseImpl.PostconditionCheck.class);

            System.equality(database.url, "//database{url}", UseDatabaseImpl.PostconditionCheck.class);

            //

            System.utility("//database", parameter, UseDatabaseImpl.PostconditionCheck.class);
        }


        return System.reference;
    }

    public static Object finalize(final String bodhi, final Class<?> klass) throws Exception
    {
        return System.reference;
    }

    public static Object utility(final String bodhi, final Parameter parameter, final Class<?> klass)
    {
        if(bodhi.equals("//database") && klass.isAssignableFrom(UseDatabaseImpl.PostconditionCheck.class))
        {
            Reader reader;
        }

        return System.reference;
    }

    public static Object peek(final String bodhi)
    {
        return Memory.reference.peek(bodhi);
    }

    public static Boolean equality(final String bodhi, final String comparable, final Class<?> klass)
    {
        try
        {
            return System.storage(bodhi).equals(comparable);
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static Boolean equality(final String bodhi, final String comparable)
    {
        return System.peek(bodhi).equals(comparable);
    }

    public static Object full(final String bodhi) throws Exception
    {
        return Memory.reference.exists(bodhi);
    }

    public static Object messager(final String bodhi, final String message, final Parameter parameter, final Class<?> context)
    {
        java.lang.System.out.println("Message: <"+message+">");

        return new Object();
    }

    public static Object stepper(final String bodhi, final Parameter parameter, final Class<?> context) throws Exception
    {
        if(context.isAssignableFrom(CreateTableImpl.PreconditionCheck.class))
        {
            Database database;

            Table table;

            System.storage("//database", database = new Database(parameter, context));

            System.storage("//database/table", table = new Table(parameter, context));

            System.storage("//database{name}", UseDatabaseImpl.Utility.getDatabaseName(parameter));

            System.storage("//database{url}", UseDatabaseImpl.Utility.getDatabaseUrl(parameter));

            //

            //System.finalize("//spin{database}", parameter, context);

            //

            return new Object();
        }
        else if(context.isAssignableFrom(CreateTableImpl.TaskRunner.class))
        {
            Database database;

            Table table;

            System.storage("//database", database = new Database(parameter, context));

            System.storage("//database/table", table = new Table(parameter, context));

            //

            Persistence persistence;

            persistence = new Persistence();

            persistence.writer.writeXML(bodhi, database, table, parameter, context);

            //

            return new Object();
        }
        else if(context.isAssignableFrom(CreateTableImpl.PostconditionCheck.class))
        {
            return new Object();
        }

        //

        else if(context.isAssignableFrom(UseDatabaseImpl.PreconditionCheck.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            if(database==null)
            {
                System.storage("//database", database = new Database(parameter, context));
            }

            System.storage("//database{name}", UseDatabaseImpl.Utility.getDatabaseName(parameter));

            System.storage("//database{url}", UseDatabaseImpl.Utility.getDatabaseUrl(parameter));

            //

            System.finalize("//spin{database}", parameter, context);
        }

        else if(context.isAssignableFrom(UseDatabaseImpl.TaskRunner.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            if(database==null)
            {
                System.storage("//database", database = new Database(parameter, context));
            }

            System.storage("//database{name}", UseDatabaseImpl.Utility.getDatabaseName(parameter));

            System.storage("//database{url}", UseDatabaseImpl.Utility.getDatabaseUrl(parameter));

            //

            System.finalize("//spin{database}", parameter, context);
        }

        else if(context.isAssignableFrom(UseDatabaseImpl.PostconditionCheck.class))
        {
            Database database;

            database = (Database) System.storage("//database");

            //

            Persistence persistence;

            persistence = new Persistence();

            persistence.reader.readXML(bodhi, database, parameter, context);

            //

            System.finalize("//spin{database}", context);
        }

        //

        else if(context.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
        {
            Database database;

            System.storage("//database", database = new Database(parameter, context));

            System.storage("//database{exists}", database.exists);

            System.storage("//database{name}", database.name);

            System.storage("//database{url}", database.url);
        }

        else if(context.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            //

            Persistence persistence;

            persistence = new Persistence();

            persistence.writer.writeXML("//database", database, parameter, CreateDatabaseImpl.TaskRunner.class);
        }

        else if(context.isAssignableFrom(CreateDatabaseImpl.PostconditionCheck.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            //

            Reader reader;

            reader = new Reader();

            reader.checkXML("//database", database, parameter, CreateDatabaseImpl.PostconditionCheck.class);
        }

        return System.reference;
    }

    public static Boolean hook(final String bodhi, final String reference) throws Exception
    {
        Object object_001 = Memory.reference.pull(bodhi);

        Object object_002 = Memory.reference.pull(reference);

        return object_001.equals(object_002);
    }

    public static Boolean hook(final String bodhi) throws Exception
    {
        return Memory.reference.exists(bodhi);
    }

    public static Boolean hook(final String bodhi, final Parameter parameter, final Class<?> klass) throws Exception
    {
        if(bodhi.equals("//database") && klass.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
        {
            //
        }

        if(bodhi.equals("") && klass.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
        {

        }

        if(bodhi.equals("") && klass.isAssignableFrom(CreateDatabaseImpl.PostconditionCheck.class))
        {

        }

        return System.memory.exists(bodhi);
    }

    public static Boolean hook(final String...names) throws Exception
    {
        Boolean result = true;

        for(String name : names)
        {
            result = Memory.reference.exists(name) & result;
        }

        return result;
    }

    public static void validate(final String name, Class<?> klass) throws Exception
    {
        ValidationComponent.reference.push(name, klass);
    }

    public static void print(final String value) throws Exception
    {
        java.lang.System.out.print(value);
    }

    public static void println(final String value) throws Exception
    {
        java.lang.System.out.println(value);
    }

    public static Boolean put(final String name) throws Exception
    {
        return Memory.reference.exists(name);
    }

    public static Object storage(final String name) throws Exception
    {
        return Memory.reference.pull(name);
    }

    public static void storage(final String string, Object object) throws Exception
    {
        Memory.reference.push(string, object);
    }

    public static void storage(final String name, String target) throws Exception
    {
        Memory.reference.push(name, target);
    }

    public static void action(final String name, Object object, Class<?> context) throws Exception
    {
        if(name.equals("//file{exists}"))
        {

        }
    }

    public static void invalidate(String name) throws Exception
    {
        Memory.reference.push(name, null);
    }

    public static void invalidate(final String bodhi, String cause) throws Exception
    {
        Memory.reference.push(bodhi, null);

        MessageQueue mqueue;

        mqueue = new MessageQueue();

        mqueue.enqueue(cause);
    }
}


