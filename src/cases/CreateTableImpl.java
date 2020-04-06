package cases;

import structures.database.Database;
import constants.DatabaseConstants;
import parameter.Parameter;
import system.System;

import java.io.File;
import java.util.StringTokenizer;

public class CreateTableImpl extends UseCase
{
    public CreateTableImpl(String sql_string) throws Exception
    {
        System.pre("//continue");

        //

        Parameter parameter = new Parameter(this, sql_string, CreateTableImpl.class);

        //

        new CreateTableImpl.CreateTableImpl_Step001(parameter);

        new CreateTableImpl.CreateTableImpl_Step002(parameter);

        new CreateTableImpl.CreateTableImpl_Step003(parameter);
    }

    public static class CreateTableImpl_Step001
    {
        public CreateTableImpl_Step001(Parameter parameter) throws Exception
        {
            PreconditionCheck check =  new PreconditionCheck(parameter);
        }
    }

    public static class CreateTableImpl_Step002
    {
        public CreateTableImpl_Step002(Parameter parameter) throws Exception
        {
             TaskRunner runner = new TaskRunner(parameter);
        }
    }

    public static class CreateTableImpl_Step003
    {
        public CreateTableImpl_Step003(Parameter parameter) throws Exception
        {
            PostconditionCheck check = new PostconditionCheck(parameter);
        }
    }

    public static class PreconditionCheck
    {
        public PreconditionCheck(Parameter parameter) throws Exception
        {
            System.hook("//continue");

                System.stepper("//database/table", parameter, CreateTableImpl.PreconditionCheck.class);

            System.hook("//continue");
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.hook("//continue");

                System.stepper("//database/table", parameter, CreateTableImpl.TaskRunner.class);

            System.hook("//continue");
        }
    }

    public static class PostconditionCheck
    {
        public PostconditionCheck(Parameter parameter) throws Exception
        {
            System.hook("//continue");

                System.stepper("//database/table", parameter, CreateTableImpl.PostconditionCheck.class);

            System.hook("//continue");
        }
    }

    public static class Utility
    {
        public static String getDatabaseExists(Parameter parameter)
        {
            try
            {
                File file = new File(DatabaseConstants.baseURL+"\\"+ CreateTableImpl.Utility.getDatabaseName(parameter)+".sql");

                return file.exists() ? "true" : "false";
            }
            catch (Exception e)
            {
                e.printStackTrace();

                return "false";
            }
        }

        public static String getDatabaseUrl(Parameter parameter)
        {
            return DatabaseConstants.baseURL +"\\"+ getDatabaseName(parameter) + ".sql";
        }

        public static String getDatabaseName(Parameter parameter)
        {
            Database database;

            database = (Database) System.peek("//database");

            if(database==null) return "No database selected";

            return database.name;
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

        public static String getTableName(Parameter parameter)
        {
            var sqlstring = parameter.sql_string;

            var tokenizer = new StringTokenizer(sqlstring, " ");

            var token001 = tokenizer.nextToken().toLowerCase();

            var token002 = tokenizer.nextToken().toLowerCase();

            var token003 = tokenizer.nextToken().toLowerCase();

            return token003;
        }
    }
}


