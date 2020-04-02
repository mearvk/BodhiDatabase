package system;

import cases.CreateDatabaseImpl;
import cases.CreateTableImpl;
import cases.UseDatabaseImpl;
import components.database.Database;
import components.memory.Memory;
import components.persistence.Persistence;
import components.processor.Processor;
import constants.DatabaseConstants;
import messaging.MessageQueue;
import parameter.Parameter;
import components.validation.ValidationComponent;
import utility.Utility;

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
            System.nullify(bodhi);
        }
    }

    public static void set(final String property, final String ref, Class klass) throws Exception
    {
        if(property.equals("//database/selected")  && klass.isAssignableFrom(UseDatabaseImpl.class))
        {
            System.push(property, ref);
        }
    }

    public static Object adhere(final String bodhi, final String memory, final Class<?> context) throws Exception
    {
        return System.reference;
    }

    public static Object adhere(final String bodhi, final Parameter parameter, final Class<?> context) throws Exception
    {
        if(bodhi.equals("//spin{database}") && context.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
        {
            Database database;

            database = (Database)System.peek("//database");

            if(database==null)
            {
                System.push("//database", database = new Database(parameter,context));
            }

            System.compare("//database{name}", database.name, context);

            System.compare("//database{url}", database.url, context);
        }

        else if(bodhi.equals("//spin{database}") && context.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
        {
            Database database;

            database = (Database)System.peek("//database");

            if(database==null)
            {
                System.push("//database", database = new Database(parameter,context));
            }
        }

        else if(bodhi.equals("//spin{database}") && context.isAssignableFrom(CreateDatabaseImpl.PostconditionCheck.class))
        {
            Database database;

            database = (Database)System.peek("//database");

            if(database==null)
            {
                System.push("//database", database = new Database(parameter,context));
            }
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

            System.compare(database.name,"//database{name}", UseDatabaseImpl.TaskRunner.class);

            System.compare(database.url, "//database{url}", UseDatabaseImpl.TaskRunner.class);

            //

            System.utility("//database", parameter, UseDatabaseImpl.TaskRunner.class);
        }

        else if(bodhi.equals("//spin{database}") && context.isAssignableFrom(UseDatabaseImpl.PostconditionCheck.class))
        {
            Database database;

            database = (Database)System.pull("//database");

            //

            System.compare(database.name,"//database{name}", UseDatabaseImpl.PostconditionCheck.class);

            System.compare(database.url, "//database{url}", UseDatabaseImpl.PostconditionCheck.class);

            //

            System.utility("//database", parameter, UseDatabaseImpl.PostconditionCheck.class);
        }


        return System.reference;
    }

    public static Object adhere(final String bodhi, final Class<?> klass) throws Exception
    {
        return System.reference;
    }

    public static Object utility(final String bodhi, Parameter parameter, final Class<?> klass)
    {
        if(bodhi.equals("//database") && klass.isAssignableFrom(UseDatabaseImpl.PostconditionCheck.class))
        {
            Utility.XMLReader reader;

            reader = new Utility.XMLReader();

            reader.existsDatabase();
        }

        return System.reference;
    }

    /**
     * Returns null if no Bodhi lookup is found
     *
     * @param bodhi lookup string
     * @return null if no match
     */
    public static Object peek(final String bodhi)
    {
        return Memory.reference.peek(bodhi);
    }

    public static Boolean compare(final String bodhi, final String comparable, final Class<?> klass) throws Exception
    {
        if(bodhi.equals("//database{name}") && klass.isAssignableFrom(UseDatabaseImpl.PostconditionCheck.class))
        {
            if(bodhi.equals(comparable)) return true;

            throw new Exception();
        }

        if(bodhi.equals("//database{url}") && klass.isAssignableFrom(UseDatabaseImpl.PostconditionCheck.class))
        {
            if(bodhi.equals(comparable)) return true;

            throw new Exception();
        }

        return true;
    }

    /**
     * Pop throws Exception if Bodhi lookup is null or unset
     *
     * @param bodhi Registry lookup
     * @return returns Boolean
     * @throws Exception If Lookup result is null or unset
     */
    public static Object full(final String bodhi) throws Exception
    {
        return Memory.reference.exists(bodhi);
    }

    /**
     * Courtesy message function w/ Bodhi
     *
     * @param bodhi
     * @return
     * @throws Exception
     */
    public static Object message(final String bodhi, final String message, final Parameter parameter, final Class<?> context)
    {
        java.lang.System.out.println("Message: <"+message+">");

        return new Object();
    }

    /**
     * SLightly stronger form than touch w/ Bodhi
     *
     * @param bodhi
     * @param parameter
     * @param context
     * @return
     * @throws Exception
     */
    public static Object set(final String bodhi, final Parameter parameter, final Class<?> context) throws Exception
    {
        if(bodhi.equals("//database") && context.isAssignableFrom(CreateTableImpl.PreconditionCheck.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            if(database==null)
            {
                System.push("//database", database = new Database(parameter, UseDatabaseImpl.PreconditionCheck.class));

                System.push("//database{name}", UseDatabaseImpl.Utility.getDatabaseName(parameter));

                System.push("//database{url}", UseDatabaseImpl.Utility.getDatabaseUrl(parameter));
            }

            System.adhere("//spin/{table}", UseDatabaseImpl.PreconditionCheck.class);
        }

        else if(bodhi.equals("//database{name}") && context.isAssignableFrom(CreateTableImpl.PreconditionCheck.class))
        {
            System.touch("//database");

            System.touch("//database{name}");
        }

        else if(bodhi.equals("//database") && context.isAssignableFrom(CreateTableImpl.TaskRunner.class))
        {
            Database database = new Database(parameter, CreateTableImpl.TaskRunner.class);

            Database.Table table = new Database.Table(parameter, CreateTableImpl.TaskRunner.class);

            System.push("//database", database);

            System.push("//database/table", table);

            System.push("//database/table{name}", table.name);

            System.push("//database/table{file}", table.url);

            //

            Persistence persistence;

            persistence = new Persistence();

            persistence.writer.writeXML(bodhi,parameter,CreateTableImpl.TaskRunner.class);
        }

        else if(bodhi.equals("//database{name}") && context.isAssignableFrom(CreateTableImpl.PostconditionCheck.class))
        {
            System.touch("//database");

            System.touch("//database{name}", CreateTableImpl.Utility.getDatabaseName(parameter));
        }

        //

        else if(bodhi.equals("//database") && context.isAssignableFrom(UseDatabaseImpl.PreconditionCheck.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            if(database==null)
            {
                System.push("//database", database = new Database(parameter, context));
            }

            System.push("//database{name}", UseDatabaseImpl.Utility.getDatabaseName(parameter));

            System.push("//database{url}", UseDatabaseImpl.Utility.getDatabaseUrl(parameter));

            System.adhere("//spin{database}", parameter, context);
        }

        else if(bodhi.equals("//database") && context.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            if(database==null)
            {
                System.push("//database", database = new Database(parameter, context));
            }

            System.push("//database{name}", CreateDatabaseImpl.Utility.getDatabaseName(parameter));

            System.push("//database{url}", CreateDatabaseImpl.Utility.getDatabaseUrl(parameter));

            //

            System.adhere("//spin{database}", parameter, context);
        }

        else if(bodhi.equals("//database") && context.isAssignableFrom(UseDatabaseImpl.PostconditionCheck.class))
        {
            Database database;

            database = (Database) System.pull("//database");

            //

            Persistence persistence;

            persistence = new Persistence();

            persistence.reader.readXML(bodhi, database.name, parameter, context);

            //

            System.adhere("//spin{database}", context);
        }

        //d

        else if(bodhi.equals("//database") && context.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
        {
            System.push("//database{name}", CreateDatabaseImpl.Utility.getDatabaseName(parameter));

            System.push("//database{file}", CreateDatabaseImpl.Utility.getDatabaseUrl(parameter));
        }

        else if(bodhi.equals("//database{name}") && context.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
        {
            String name = CreateDatabaseImpl.Utility.getDatabaseName(parameter).trim();

            String[] names = CreateDatabaseImpl.Utility.getExistingDatabaseNames(parameter);

            for(int i=0; i<names.length; i++)
            {
                if(names[i].equals(name))
                {
                    System.nullify("//continue","Database <"+name+"> exists already; see file <"+ DatabaseConstants.baseURL+"\\"+name+".sql>");
                }
            }
        }

        else if(bodhi.equals("//database") && context.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
        {
            Database database;

            System.push("//database", database = new Database(parameter, CreateDatabaseImpl.TaskRunner.class));

            System.push("//database/{name}", database.name);

            System.push("//database/{file}", database.url);

            //

            Persistence persistence;

            persistence = new Persistence();

            persistence.writer.writeXML("//database", parameter, CreateDatabaseImpl.TaskRunner.class);
        }

        else if(bodhi.equals("//database") && context.isAssignableFrom(CreateDatabaseImpl.PostconditionCheck.class))
        {
            System.push("//database/{ready}", true);
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

    public static void push(final String name, Object object) throws Exception
    {
        Memory.reference.push(name, object);
    }

    public static void push(final String name, String target) throws Exception
    {
        Memory.reference.push(name, target);
    }

    public static void nullify(String name) throws Exception
    {
        Memory.reference.push(name, null);
    }

    public static void nullify(final String bodhi, String cause) throws Exception
    {
        Memory.reference.push(bodhi, null);

        MessageQueue mqueue;

        mqueue = new MessageQueue();

        mqueue.enqueue(cause);
    }
}

