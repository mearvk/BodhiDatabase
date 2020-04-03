package system;

import cases.CreateDatabaseImpl;
import cases.CreateTableImpl;
import cases.UseDatabaseImpl;
import components.database.Database;
import components.memory.Memory;
import components.persistence.Persistence;
import components.processor.Processor;
import messaging.MessageQueue;
import parameter.Parameter;
import components.validation.ValidationComponent;
import structures.table.Table;
import utility.Reader;
import utility.Writer;

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
            System.push(bodhi, true);
        }
    }

    public static void unset(final String bodhi) throws Exception
    {
        if(bodhi.equals("//continue"))
        {
            System.invalidate(bodhi);
        }
    }

    public static void step(final String property, final String ref, Class klass) throws Exception
    {
        if(property.equals("//database/selected")  && klass.isAssignableFrom(UseDatabaseImpl.class))
        {
            System.push(property, ref);
        }
    }

    public static Object spin(final String bodhi, final String memory, final Class<?> context) throws Exception
    {
        return System.reference;
    }

    public static Object spin(final String bodhi, final Parameter parameter, final Class<?> context) throws Exception
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
                System.push("//database", database = new Database(parameter,context));
            }

            Persistence persistence;

            persistence = new Persistence();

            persistence.writer.writeXML(bodhi, database, parameter, context);
        }

        else if(bodhi.equals("//spin{database}") && context.isAssignableFrom(CreateDatabaseImpl.PostconditionCheck.class))
        {
            Database database;

            database = (Database)System.peek("//database");

            if(database==null)
            {
                System.push("//database", database = new Database(parameter,context));
            }

            Reader reader;

            reader = new Reader();

            reader.checkXML(bodhi, database, parameter, context);
        }

        //

        else if(bodhi.equals("//spin{database}") && context.isAssignableFrom(UseDatabaseImpl.PreconditionCheck.class))
        {
            Database database;

            database = (Database)System.pull("//database");

            //

            System.full("//database{name}");

            System.full("//database{url}");

            //

            database.name = (String)System.pull("//database{name}");

            database.url = (String)System.pull("//database{url}");
        }

        else if(bodhi.equals("//spin{database}") && context.isAssignableFrom(UseDatabaseImpl.TaskRunner.class))
        {
            Database database;

            database = (Database)System.pull("//database");

            //

            System.equality(database.name,"//database{name}", UseDatabaseImpl.TaskRunner.class);

            System.equality(database.url, "//database{url}", UseDatabaseImpl.TaskRunner.class);

            //

            System.utility("//database", parameter, UseDatabaseImpl.TaskRunner.class);
        }

        else if(bodhi.equals("//spin{database}") && context.isAssignableFrom(UseDatabaseImpl.PostconditionCheck.class))
        {
            Database database;

            database = (Database)System.pull("//database");

            //

            System.equality(database.name,"//database{name}", UseDatabaseImpl.PostconditionCheck.class);

            System.equality(database.url, "//database{url}", UseDatabaseImpl.PostconditionCheck.class);

            //

            System.utility("//database", parameter, UseDatabaseImpl.PostconditionCheck.class);
        }


        return System.reference;
    }

    public static Object spin(final String bodhi, final Class<?> klass) throws Exception
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

    public static Boolean equality(final String bodhi, final String comparable, final Class<?> klass) throws Exception
    {
        if(bodhi.equals(comparable)) return true;

        throw new Exception();
    }

    public static Boolean equality(final String bodhi, final Object comparable) throws Exception
    {
        if(bodhi.equals(comparable)) return true;

        throw new Exception();
    }

    public static Object full(final String bodhi) throws Exception
    {
        return Memory.reference.exists(bodhi);
    }

    public static Object message(final String bodhi, final String message, final Parameter parameter, final Class<?> context)
    {
        java.lang.System.out.println("Message: <"+message+">");

        return new Object();
    }

    public static Object step(final String bodhi, final Parameter parameter, final Class<?> context) throws Exception
    {
        if(context.isAssignableFrom(CreateTableImpl.PreconditionCheck.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            if(database==null)
            {
                System.push("//database", database = new Database(parameter, CreateTableImpl.PreconditionCheck.class));

                System.push("//database{name}", CreateTableImpl.Utility.getDatabaseName(parameter));

                System.push("//database{url}", CreateTableImpl.Utility.getDatabaseUrl(parameter));
            }

            System.spin("//spin/{table}", CreateTableImpl.PreconditionCheck.class);
        }

        else if(context.isAssignableFrom(CreateTableImpl.TaskRunner.class))
        {
            Database database = new Database(parameter, context);

            Table table = new Table(parameter);

            System.push("//database", database);

            System.push("//database/table", table);

            System.push("//database/table{name}", table.name);

            System.push("//database/table{url}", table.url);

            //

            Persistence persistence;

            persistence = new Persistence();

            persistence.writer.writeXML(bodhi, database, table, parameter,CreateTableImpl.TaskRunner.class);
        }

        else if(context.isAssignableFrom(CreateTableImpl.PostconditionCheck.class))
        {
            System.touch("//database");

            System.touch("//database{name}", CreateTableImpl.Utility.getDatabaseName(parameter));
        }

        //

        else if(context.isAssignableFrom(UseDatabaseImpl.PreconditionCheck.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            if(database==null)
            {
                System.push("//database", database = new Database(parameter, context));
            }

            System.push("//database{name}", UseDatabaseImpl.Utility.getDatabaseName(parameter));

            System.push("//database{url}", UseDatabaseImpl.Utility.getDatabaseUrl(parameter));

            System.spin("//spin{database}", parameter, context);
        }

        else if(context.isAssignableFrom(UseDatabaseImpl.TaskRunner.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            if(database==null)
            {
                System.push("//database", database = new Database(parameter, context));
            }

            System.push("//database{name}", UseDatabaseImpl.Utility.getDatabaseName(parameter));

            System.push("//database{url}", UseDatabaseImpl.Utility.getDatabaseUrl(parameter));

            //

            System.spin("//spin{database}", parameter, context);
        }

        else if(context.isAssignableFrom(UseDatabaseImpl.PostconditionCheck.class))
        {
            Database database;

            database = (Database) System.pull("//database");

            //

            Persistence persistence;

            persistence = new Persistence();

            persistence.reader.readXML(bodhi, database, parameter, context);

            //

            System.spin("//spin{database}", context);
        }

        //

        else if(context.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            if(database==null)
            {
                System.push("//database", database = new Database(parameter, context));
            }

            System.push("//database{exists}", database.exists);

            System.push("//database{name}", database.name);

            System.push("//database{url}", database.url);
        }

        else if(context.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            //

            Writer writer;

            writer = new Writer();

            writer.writeXML("//database", database, parameter, CreateDatabaseImpl.TaskRunner.class);
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

    public static Boolean touch(final String bodhi, final String reference) throws Exception
    {
        Object object_001 = Memory.reference.pull(bodhi);

        Object object_002 = Memory.reference.pull(reference);

        return object_001.equals(object_002);
    }

    public static Boolean touch(final String bodhi) throws Exception
    {
        return Memory.reference.exists(bodhi);
    }

    public static Boolean touch(final String bodhi, final Parameter parameter, final Class<?> klass) throws Exception
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

    public static Boolean touch(final String...names) throws Exception
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

    public static Object pull(final String name) throws Exception
    {
        return Memory.reference.pull(name);
    }

    public static void push(final String name, Class<?> klass) throws Exception
    {

    }

    public static void push(final String name, Reader reader, Database database) throws Exception
    {

    }

    public static void push(final String name, Object object) throws Exception
    {
        Memory.reference.push(name, object);
    }

    public static void push(final String name, String target) throws Exception
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

