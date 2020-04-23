package system;

import cases.CreateDatabaseImpl;
import cases.CreateTableImpl;
import cases.UseDatabaseImpl;

import org.xml.io.Writer;
import structures.table.Table;
import structures.database.Database;

import components.memory.Memory;
import components.persistence.Persistence;
import components.processor.Processor;
import components.validation.ValidationComponent;

import messaging.MessageQueue;

import parameter.Parameter;

import io.Reader;
import system.properties.SystemProperty;
import system.registry.SystemRegister;

import javax.xml.crypto.Data;
import java.util.HashMap;

public class System
{
    public static System reference;

    public static Memory memory = new Memory();

    public static Processor processor;

    private Database database;

    public HashMap<String, SystemProperty> properties = new HashMap();

    //

    public System() throws Exception
    {
        System.reference = this;

        System.processor = new Processor();
    }

    //

    public static void pin(final String bodhi, final Object object, Class<?> context) throws Exception
    {
        Memory.reference.push(bodhi, object);
    }

    public static void pin(final String bodhi, final String attribute, final Object object, Class<?> context) throws Exception
    {
        Memory.reference.push(bodhi+""+attribute, object);
    }

    public static void property(final String propertyURI, SystemProperty property) throws Exception
    {
        System.reference.properties.put(propertyURI, property);
    }

    public static void pull(final String bodhi) throws Exception
    {
        if(Memory.reference.pull(bodhi)==null) throw new Exception();

        return;
    }

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
        if(context.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
        {
            Database database = (Database)System.peek("//database");

            System.compare("//database{exists}", database.exists);

            System.compare("//database{name}", database.name);

            System.compare("//database{url}", database.uri);

            return System.reference;
        }

        else if(context.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
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

            database.uri = (String)System.storage("//database{url}");
        }

        else if(bodhi.equals("//spin{database}") && context.isAssignableFrom(UseDatabaseImpl.TaskRunner.class))
        {
            Database database;

            database = (Database)System.storage("//database");

            //

            System.compare(database.name,"//database{name}", UseDatabaseImpl.TaskRunner.class);

            System.compare(database.uri, "//database{url}", UseDatabaseImpl.TaskRunner.class);

            //

            System.utility("//database", parameter, UseDatabaseImpl.TaskRunner.class);
        }

        else if(bodhi.equals("//spin{database}") && context.isAssignableFrom(UseDatabaseImpl.PostconditionCheck.class))
        {
            Database database;

            database = (Database)System.storage("//database");

            //

            System.compare(database.name,"//database{name}", UseDatabaseImpl.PostconditionCheck.class);

            System.compare(database.uri, "//database{url}", UseDatabaseImpl.PostconditionCheck.class);

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

    public static Boolean compare(final String bodhi, final String comparator, final Class<?> klass)
    {
        try
        {
            return System.storage(bodhi).equals(comparator);
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static Boolean evaluate(final String bodhi, final String property, final Parameter parameter, final Class<?> context) throws Exception
    {
        if(context.isAssignableFrom(UseDatabaseImpl.PostconditionCheck.class))
        {
            if(property.equalsIgnoreCase("@selected"))
            {
                Database database = (Database)Memory.reference.pull("//database");

                return database.selected.equalsIgnoreCase("true");
            }

            if(property.equalsIgnoreCase("@writ"))
            {
                //TODO fill in & create a database writ system
            }
        }

        return true;
    }

    public static Boolean aequalitas(final String bodhi, final String property, final Object object, final Class<?> context) throws Exception
    {
        if(context.isAssignableFrom(UseDatabaseImpl.TaskRunner.class))
        {
            Database comparator01, comparator02;

            comparator01 = (Database) System.peek(bodhi);

            if(object instanceof Database)
            {
                Boolean result01, result02;

                comparator02 = (Database) object;

                result01 = comparator01.name.equalsIgnoreCase(comparator02.name);

                result02 = comparator01.uri.equalsIgnoreCase(comparator02.uri);

                return result01 & result02;
            }
        }

        return true;
    }

    public static Boolean aequalitas(final String bodhi, final Object object, final Class<?> context) throws Exception
    {
        if(context.isAssignableFrom(UseDatabaseImpl.TaskRunner.class))
        {
            Database comparator01, comparator02;

            comparator01 = (Database) System.peek(bodhi);

            if(object instanceof Database)
            {
                Boolean result01, result02;

                comparator02 = (Database) object;

                result01 = comparator01.name.equalsIgnoreCase(comparator02.name);

                result02 = comparator01.uri.equalsIgnoreCase(comparator02.uri);

                return result01 & result02;
            }
        }

        return true;
    }

    public static Boolean inaequalitas(final String bodhi, final Object object, final Class<?> context) throws Exception
    {
        if(context.isAssignableFrom(UseDatabaseImpl.PreconditionCheck.class))
        {
            Database comparator01, comparator02;

            comparator01 = (Database) System.peek(bodhi);

            if(object instanceof Database)
            {
                Boolean result01, result02;

                comparator02 = (Database) object;

                result01 = comparator01.name.equalsIgnoreCase(comparator02.name);

                result02 = comparator01.uri.equalsIgnoreCase(comparator02.uri);

                return !(result01 & result02);
            }
        }

        return true;
    }

    public static Boolean compare(final String bodhi, final String comparable)
    {
        return System.peek(bodhi).equals(comparable);
    }

    public static Boolean assertion(final String bodhi, String key) throws Exception
    {
        return Memory.reference.exists(bodhi);
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

        else if(context.isAssignableFrom(UseDatabaseImpl.PreconditionCheck.class))
        {
            /* 04/20/2020 @maxrupplin */

            Database database;

            if(System.inaequalitas("//database", new Database(parameter, context), UseDatabaseImpl.PreconditionCheck.class))
            {
                System.pin("//database", database = new Database(parameter, context), UseDatabaseImpl.PreconditionCheck.class);

                System.pin("//database", "@self", database, UseDatabaseImpl.PreconditionCheck.class);

                System.pin("//database", "@name", database.name, UseDatabaseImpl.PreconditionCheck.class);

                System.pin("//database", "@uri", database.uri, UseDatabaseImpl.PreconditionCheck.class) ;
            }
        }

        else if(context.isAssignableFrom(UseDatabaseImpl.TaskRunner.class))
        {
            /* 04/20/2020 @maxrupplin */

            Database database;

            if(System.aequalitas("//database", new Database(parameter, context), UseDatabaseImpl.TaskRunner.class))
                return System.reference;

            System.pin("//database", database = new Database(parameter, context), UseDatabaseImpl.PreconditionCheck.class);

            System.pin("//database", "@self", database, UseDatabaseImpl.PreconditionCheck.class);

            System.pin("//database", "@name", database.name, UseDatabaseImpl.PreconditionCheck.class);

            System.pin("//database", "@uri", database.uri, UseDatabaseImpl.PreconditionCheck.class);

            System.pin("//database", "@selected", database.selected, UseDatabaseImpl.PreconditionCheck.class);

            System.pin("//database", "@file", database.file, UseDatabaseImpl.PreconditionCheck.class);
        }

        else if(context.isAssignableFrom(UseDatabaseImpl.PostconditionCheck.class))
        {
            /* 04/21/2020 @maxrupplin */

            System.evaluate("//database","@selected", parameter, context);

            System.evaluate("//database","@writ", parameter, context);
        }

        else if(context.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
        {
            /* aloha */

            Database database;

            System.pin("//database", "@self", database = new Database(parameter, context), CreateDatabaseImpl.PreconditionCheck.class);

            System.pin("//database", "@exists", database.exists, CreateDatabaseImpl.PreconditionCheck.class);

            System.pin("//database", "@name", database.name, CreateDatabaseImpl.PreconditionCheck.class);

            System.pin("//database", "@uri", database.uri, CreateDatabaseImpl.PreconditionCheck.class);
        }

        else if(context.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
        {
            Database database;

            System.pin("//database", "@self", database = new Database(parameter, context), CreateDatabaseImpl.TaskRunner.class);

            System.pin("//database", "@writ", database.writ, CreateDatabaseImpl.TaskRunner.class);
        }

        else if(context.isAssignableFrom(CreateDatabaseImpl.PostconditionCheck.class))
        {
            Database database;

            System.pin("//database", "@self", database = new Database(parameter, context), CreateDatabaseImpl.TaskRunner.class);

            System.pin("//database", "@writ", database.writ, CreateDatabaseImpl.TaskRunner.class);
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

    public static void storage(final String bodhi, final SystemProperty property, final Object object)
    {

    }

    public static void storage(final String bodhi, final SystemKey key, final Object object)
    {

    }

    public static void storage(final String bodhi, final String keypair, final Object object)
    {

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


