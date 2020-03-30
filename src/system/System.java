package system;

import cases.CreateDatabaseImpl;
import cases.UseDatabaseImpl;
import components.database.Database;
import components.memory.Memory;
import components.processor.Processor;
import contexts.CreateDatabaseImplContext;
import contexts.UseDatabaseImplContext;
import exceptions.DatabaseExistsAlreadyException;
import parameter.Parameter;
import components.validation.ValidationComponent;

import java.nio.file.attribute.UserDefinedFileAttributeView;

import static java.lang.Boolean.FALSE;
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

    public static void set(String property, String ref, Class klass) throws Exception
    {
        if(property.equals("//database/selected")  && klass.isAssignableFrom(UseDatabaseImplContext.class))
        {
            System.push(property, ref);
        }
    }

    public static void set(String bodhi, Parameter parameter, Class<?> klass) throws Exception
    {
        //

        if(bodhi.equals("//database") && klass.isAssignableFrom(UseDatabaseImplContext.PreconditionCheckContext.class))
        {
            System.push("//database/{ready}", FALSE);
        }

        if(bodhi.equals("//database") && klass.isAssignableFrom(UseDatabaseImplContext.TaskRunnerContext.class))
        {
            System.push("//database/{ready}", FALSE);

            System.push("//database", new Database(parameter));

            System.push("//database/{name}", Database.reference.name);

            System.push("//database/{file}", Database.reference.file);

            System.push("//database/{ready}", TRUE);
        }

        if(bodhi.equals("//database") && klass.isAssignableFrom(UseDatabaseImplContext.PostconditionCheckContext.class))
        {
            System.push("//database/{ready}", TRUE);
        }

        //

        if(bodhi.equals("//database") && klass.isAssignableFrom(UseDatabaseImplContext.class))
        {
            System.push(bodhi, "//database");
        }

        if(bodhi.equals("//database/selected")  && klass.isAssignableFrom(UseDatabaseImplContext.class))
        {
            System.push(bodhi, "//database");
        }

        if(bodhi.equals("//database/properties/name") && klass.isAssignableFrom(UseDatabaseImplContext.class))
        {
            System.push(bodhi, UseDatabaseImpl.Utility.getDatabaseName(parameter));
        }

        if(bodhi.equals("//database/properties/file") && klass.isAssignableFrom(UseDatabaseImplContext.class))
        {
            String name = parameter.name = (String)System.pull("//database/properties/name");

            System.push(bodhi, UseDatabaseImpl.Utility.getDatabaseFile(parameter));
        }
    }

    public static Boolean touch(String name) throws Exception
    {
        return Memory.reference.exists(name);
    }

    public static Boolean touch(String bodhi, Parameter parameter, Class<?> klass) throws Exception
    {
        if(bodhi.equals("//database") && klass.isAssignableFrom(CreateDatabaseImplContext.PreConditionRunnerContext.class))
        {
            var name = CreateDatabaseImpl.Utility.getDatabaseName(parameter);

            var names = CreateDatabaseImpl.Utility.getDatabaseNames(parameter);

            for(int i=0; i<names.length; i++)
            {
                if(names[i].equalsIgnoreCase(name))

                    new Exception().addSuppressed(new DatabaseExistsAlreadyException("Database exists already"));
            }

            return true;
        }

        if(bodhi.equals("") && klass.isAssignableFrom(CreateDatabaseImplContext.TaskRunnerContext.class))
        {

        }

        if(bodhi.equals("") && klass.isAssignableFrom(CreateDatabaseImplContext.PostConditionRunnerContext.class))
        {

        }

        return System.memory.exists(bodhi);
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
}

