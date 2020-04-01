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

import javax.swing.text.Element;

import static java.lang.Boolean.TRUE;

public class System
{
    public static System reference;

    public static Memory memory = new Memory();

    //public static DatabaseHandler database = new DatabaseHandler();

    //public static ValidationComponent validator = new ValidationComponent();

    public static Processor processor;

    private Database database;

    //

    public System() throws Exception
    {
        System.reference = this;

        System.processor = new Processor();
    }

    //

    public static void pre(String bodhi) throws Exception
    {
        if(bodhi.equals("//continue"))
        {
            System.push(bodhi, true);
        }
    }

    public static void unset(String bodhi) throws Exception
    {
        if(bodhi.equals("//continue"))
        {
            System.nullify(bodhi);
        }
    }

    public static void set(String property, String ref, Class klass) throws Exception
    {
        if(property.equals("//database/selected")  && klass.isAssignableFrom(UseDatabaseImpl.class))
        {
            System.push(property, ref);
        }
    }

    public static Object spin(final String bodhi, final Class<?> klass) throws Exception
    {
        if(bodhi.equals("//spin/{database}") && klass.isAssignableFrom(UseDatabaseImpl.PreconditionCheck.class))
        {
            Database database;

            database = (Database)System.pull("//database");

            //

            System.pop("//database{name}");

            System.pop("//database{url}");

            //

            String name = database.name = (String)System.pull("//database{name}");

            String url = database.url = (String)System.pull("//database{url}");
        }

        if(bodhi.equals("//spin/{database}") && klass.isAssignableFrom(UseDatabaseImpl.TaskRunner.class))
        {
            Database database;

            database = (Database)System.pull("//database");

            //

            System.pop("//database{name}");

            System.pop("//database{url}");

            //

            String name = database.name = (String)System.pull("//database{name}");

            String url = database.url = (String)System.pull("//database{url}");
        }

        return System.reference;
    }

    public static Object peek(final String bodhi)
    {
        return Memory.reference.peek(bodhi);
    }

    public static Boolean compare(final String bodhi, final String compared, final Class<?> klass) throws Exception
    {
        return true;
    }

    public static Object pop(final String bodhi) throws Exception
    {
        return Memory.reference.exists(bodhi);
    }

    public static Object set(final String bodhi, final Parameter parameter, final Class<?> klass) throws Exception
    {
        if(bodhi.equals("//database") && klass.isAssignableFrom(CreateTableImpl.PreconditionCheck.class))
        {
            System.touch("//database");

            System.touch("//database{name}");
        }

        if(bodhi.equals("//database{name}") && klass.isAssignableFrom(CreateTableImpl.PreconditionCheck.class))
        {
            System.touch("//database");

            System.touch("//database{name}");
        }

        if(bodhi.equals("//database") && klass.isAssignableFrom(CreateTableImpl.TaskRunner.class))
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

        if(bodhi.equals("//database{name}") && klass.isAssignableFrom(CreateTableImpl.PostconditionCheck.class))
        {
            System.touch("//database");

            System.touch("//database{name}", CreateTableImpl.Utility.getDatabaseName(parameter));
        }

        //

        if(bodhi.equals("//database") && klass.isAssignableFrom(UseDatabaseImpl.PreconditionCheck.class))
        {
            Database database;

            database = (Database) System.peek("//database");

            if(database==null)
            {
                System.push("//database", database = new Database(parameter, UseDatabaseImpl.PreconditionCheck.class));

                System.push("//database{name}", UseDatabaseImpl.Utility.getDatabaseName(parameter));

                System.push("//database{url}", UseDatabaseImpl.Utility.getDatabaseUrl(parameter));

                //

                System.spin("//database/{spin}", UseDatabaseImpl.PreconditionCheck.class);

                return System.reference;
            }
            else
            {
                System.spin("//spin/{database}", UseDatabaseImpl.TaskRunner.class);
            }
        }

        if(bodhi.equals("//database") && klass.isAssignableFrom(UseDatabaseImpl.TaskRunner.class))
        {
            Database database;

            database = (Database) System.pull("//database");

            if(database==null)
            {
                System.push("//database", database = new Database(parameter, UseDatabaseImpl.TaskRunner.class));

                System.push("//database/{name}", database.name);

                System.push("//database/{url}", database.url);

                //

                System.spin("//database/{spin}", UseDatabaseImpl.TaskRunner.class);
            }
            else
            {
                System.spin("//spin/{database}", UseDatabaseImpl.TaskRunner.class);
            }
        }

        if(bodhi.equals("//database") && klass.isAssignableFrom(UseDatabaseImpl.PostconditionCheck.class))
        {
            System.push("//database/{ready}", TRUE);
        }

        //

        if(bodhi.equals("//database") && klass.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
        {
            System.push("//database{name}", CreateDatabaseImpl.Utility.getDatabaseName(parameter));

            System.push("//database{file}", CreateDatabaseImpl.Utility.getDatabaseFile(parameter));
        }

        if(bodhi.equals("//database{name}") && klass.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
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

        if(bodhi.equals("//database") && klass.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
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

        if(bodhi.equals("//database") && klass.isAssignableFrom(CreateDatabaseImpl.PostconditionCheck.class))
        {
            System.push("//database/{ready}", TRUE);
        }

        return System.reference;
    }

    public static Boolean touch(String bodhi, String reference) throws Exception
    {
        Object object_001 = Memory.reference.pull(bodhi);

        Object object_002 = Memory.reference.pull(reference);

        return object_001.equals(object_002);
    }

    public static Boolean touch(String bodhi) throws Exception
    {
        return Memory.reference.exists(bodhi);
    }

    public static Boolean touch(String bodhi, Parameter parameter, Class<?> klass) throws Exception
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

    public static Boolean touch(@org.jetbrains.annotations.NotNull String...names) throws Exception
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

    public static Object pull(String name) throws Exception
    {
        return Memory.reference.pull(name);
    }

    public static void push(String name, Class<?> klass) throws Exception
    {

    }

    public static void push(String name, Object object) throws Exception
    {
        Memory.reference.push(name, object);
    }

    public static void push(String name, String target) throws Exception
    {
        Memory.reference.push(name, target);
    }

    public static void nullify(String name) throws Exception
    {
        Memory.reference.push(name, null);
    }

    public static void nullify(String bodhi, String cause) throws Exception
    {
        Memory.reference.push(bodhi, null);

        MessageQueue mqueue;

        mqueue = new MessageQueue();

        mqueue.enqueue(cause);
    }
}

