package cases;

import constants.DatabaseConstants;
import contexts.CreateDatabaseImplContext;
import exceptions.DatabaseException;
import parameter.Parameter;
import system.System;

import java.io.File;
import java.util.StringTokenizer;

public class CreateDatabaseImpl extends UseCase
{
    public CreateDatabaseImpl_Step001 step001;

    public CreateDatabaseImpl_Step002 step002;

    public CreateDatabaseImpl_Step003 step003;

    public Parameter parameter;

    public CreateDatabaseImpl(String sqlString) throws Exception
    {
        System.push("//impl/createdatabase", this);

        //

        this.parameter = new Parameter(this, sqlString);

        //

        try
        {
            this.step001 = new CreateDatabaseImpl_Step001(this.parameter);

            this.step002 = new CreateDatabaseImpl_Step002(this.parameter);

            this.step003 = new CreateDatabaseImpl_Step003(this.parameter);
        }
        catch (DatabaseException daee)
        {
            daee.printStackTrace();
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class CreateDatabaseImpl_Step001
    {
        public CreateDatabaseImpl_Step001(Parameter parameter) throws Exception
        {
            System.push("//step001", new PreConditionRunner(parameter));
        }
    }

    public static class CreateDatabaseImpl_Step002
    {
        public CreateDatabaseImpl_Step002(Parameter parameter) throws Exception
        {
            System.push("//step002", new TaskRunner(parameter));
        }
    }

    public static class CreateDatabaseImpl_Step003
    {
        public CreateDatabaseImpl_Step003(Parameter parameter) throws Exception
        {
            System.push("//step003", new PostConditionRunner(parameter));
        }
    }

    public static class PreConditionRunner
    {
        public PreConditionRunner(Parameter parameter) throws Exception
        {
            System.touch("//database", parameter, CreateDatabaseImplContext.PreConditionRunnerContext.class);
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.processor.set("//database", parameter, CreateDatabaseImplContext.TaskRunnerContext.class);
        }
    }

    public static class PostConditionRunner
    {
        public PostConditionRunner(Parameter parameter) throws Exception
        {
            System.touch("//database", parameter, CreateDatabaseImplContext.PostConditionRunnerContext.class);
        }
    }

    public static class Utility
    {
        public static String getDatabaseFile(Parameter parameter)
        {
            return DatabaseConstants.baseURL +"\\"+ parameter.name + ".sql";
        }

        public static String getDatabaseName(Parameter parameter)
        {
            var sqlstring = parameter.sqlstring;

            var tokenizer = new StringTokenizer(sqlstring, " ");

            var token001 = tokenizer.nextToken().toLowerCase();

            var token002 = tokenizer.nextToken().toLowerCase();

            var token003 = tokenizer.nextToken().toLowerCase();

            return token003;
        }

        public static String[] getDatabaseNames(Parameter parameter)
        {
            var files = new File(DatabaseConstants.baseURL).listFiles();

            var names = new String[files.length];

            for(int i=0; i<files.length; i++)
            {
                StringTokenizer tokenizer = new StringTokenizer(files[i].getName(), ".");

                names[i] = tokenizer.nextToken();
            }

            return names;
        }
    }
}

