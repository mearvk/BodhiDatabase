package system;

import cases.CreateDatabaseImpl;
import cases.CreateTableImpl;
import cases.UseDatabaseImpl;

import structures.database.Database;

import components.memory.Memory;
import components.persistence.Persistence;
import components.processor.Processor;
import messaging.MessageQueue;
import parameter.Parameter;
import components.validation.ValidationComponent;
import structures.table.Table;
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
            System.save(bodhi, true);
        }
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
            System.save(property, ref);
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
                System.save("//database", database = new Database(parameter,context));
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
                System.save("//database", database = new Database(parameter,context));
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

    public static Boolean equality(final String bodhi, final String comparable, final Class<?> klass)
    {
        try
        {
            return System.pull(bodhi).equals(comparable);
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

            String name;

            String url;

            //

            System.save("//database", database = new Database(parameter, context));

            System.save("//database/tables{table}", table = new Table(parameter, context));

            System.save("//database{name}", name = CreateTableImpl.Utility.getDatabaseName(parameter));

            System.save("//database{url}", url = CreateTableImpl.Utility.getDatabaseUrl(parameter));
        }
        else if(context.isAssignableFrom(CreateTableImpl.TaskRunner.class))
        {
            Database database;

            Table table;

            //TODO IS DB AND TABLE INSIDE OUT?

            System.save("//database", database = (Database) System.pull("//database"));

            System.save("//database/tables{table}", table = (Table) System.pull("//database/tables{table}"));

            System.save("//database/tables/table{name}", table.name);

            System.save("//database/tables/table{url}", table.url);

            //

            //TODO check here

            //

            Persistence persistence;

            persistence = new Persistence();

            persistence.writer.writeXML(bodhi, database, table, parameter, context);
        }

        else if(context.isAssignableFrom(CreateTableImpl.PostconditionCheck.class))
        {
            System.touch_base("//database");

            System.touch_base("//database{name}", CreateTableImpl.Utility.getDatabaseName(parameter));
        }

        //

        else if(context.isAssignableFrom(UseDatabaseImpl.PreconditionCheck.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            if(database==null)
            {
                System.save("//database", database = new Database(parameter, context));
            }

            System.save("//database{name}", UseDatabaseImpl.Utility.getDatabaseName(parameter));

            System.save("//database{url}", UseDatabaseImpl.Utility.getDatabaseUrl(parameter));

            //

            System.spin("//spin{database}", parameter, context);
        }

        else if(context.isAssignableFrom(UseDatabaseImpl.TaskRunner.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            if(database==null)
            {
                System.save("//database", database = new Database(parameter, context));
            }

            System.save("//database{name}", UseDatabaseImpl.Utility.getDatabaseName(parameter));

            System.save("//database{url}", UseDatabaseImpl.Utility.getDatabaseUrl(parameter));

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

            System.save("//database", database = new Database(parameter, context));

            System.save("//database{exists}", database.exists);

            System.save("//database{name}", database.name);

            System.save("//database{url}", database.url);
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

    public static Boolean touch_base(final String bodhi, final String reference) throws Exception
    {
        Object object_001 = Memory.reference.pull(bodhi);

        Object object_002 = Memory.reference.pull(reference);

        return object_001.equals(object_002);
    }

    public static Boolean touch_base(final String bodhi) throws Exception
    {
        return Memory.reference.exists(bodhi);
    }

    public static Boolean touch_base(final String bodhi, final Parameter parameter, final Class<?> klass) throws Exception
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

    public static Boolean touch_base(final String...names) throws Exception
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

    public static void save(final String string, Object object) throws Exception
    {
        Memory.reference.push(string, object);
    }

    public static void save(final String name, String target) throws Exception
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

