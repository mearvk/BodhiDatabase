package cases;

import constants.DatabaseConstants;
import parameter.Parameter;
import system.System;

import java.io.File;
import java.util.StringTokenizer;

public class CreateDatabaseImpl extends UseCase
{
    public CreateDatabaseImpl(String sql_string) throws Exception
    {
        System.pre("//continue");

        //

        Parameter parameter = new Parameter(this, sql_string, CreateDatabaseImpl.class);

        //

        new CreateDatabaseImpl.CreateDatabaseImpl_Step001(parameter);

        new CreateDatabaseImpl.CreateDatabaseImpl_Step002(parameter);

        new CreateDatabaseImpl.CreateDatabaseImpl_Step003(parameter);
    }

    public static class CreateDatabaseImpl_Step001
    {
        public CreateDatabaseImpl_Step001(Parameter parameter) throws Exception
        {
            PreconditionCheck check = new PreconditionCheck(parameter);
        }
    }

    public static class CreateDatabaseImpl_Step002
    {
        public CreateDatabaseImpl_Step002(Parameter parameter) throws Exception
        {
            TaskRunner runner = new TaskRunner(parameter);
        }
    }

    public static class CreateDatabaseImpl_Step003
    {
        public CreateDatabaseImpl_Step003(Parameter parameter) throws Exception
        {
            PostconditionCheck check = new PostconditionCheck(parameter);
        }
    }

    public static class PreconditionCheck
    {
        public PreconditionCheck(Parameter parameter) throws Exception
        {
            System.hook("//continue");

                System.stepper("//database", parameter, CreateDatabaseImpl.PreconditionCheck.class);

            System.hook("//continue");
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.hook("//continue");

                System.stepper("//database", parameter, CreateDatabaseImpl.TaskRunner.class);

            System.hook("//continue");
        }
    }

    public static class PostconditionCheck
    {
        public PostconditionCheck(Parameter parameter) throws Exception
        {
            System.hook("//continue");

                 System.stepper("//database", parameter, CreateDatabaseImpl.PostconditionCheck.class);

            System.hook("//continue");
        }
    }

    public static class Utility
    {
        public static String getDatabaseExists(Parameter parameter)
        {
            try
            {
                File file = new File(DatabaseConstants.baseURL+"\\"+Utility.getDatabaseName(parameter)+".sql");

                return file.exists() ? "true" : "false";
            }
            catch (Exception e)
            {
                return "false";
            }
        }

        public static String getDatabaseUrl(Parameter parameter)
        {
            return DatabaseConstants.baseURL +"\\"+ getDatabaseName(parameter) + ".sql";
        }

        public static String getDatabaseName(Parameter parameter)
        {
            var sqlstring = parameter.sql_string;

            var tokenizer = new StringTokenizer(sqlstring, " ");

            var token001 = tokenizer.nextToken().toLowerCase();

            var token002 = tokenizer.nextToken().toLowerCase();

            var token003 = tokenizer.nextToken().toLowerCase();

            return token003;
        }

        public static String[] getExistingDatabaseNames(Parameter parameter)
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

