package cases;

import constants.DatabaseConstants;
import parameter.Parameter;
import system.System;

import java.io.File;
import java.util.StringTokenizer;

public class CreateTableImpl extends UseCase
{
    public CreateTableImpl(String sqlstring) throws Exception
    {
        System.pre("//continue");

        //

        Parameter parameter = new Parameter(this, sqlstring);

        //

        CreateTableImpl.CreateTableImpl_Step001 step001 = new CreateTableImpl.CreateTableImpl_Step001(parameter);

        CreateTableImpl.CreateTableImpl_Step002 step002 = new CreateTableImpl.CreateTableImpl_Step002(parameter);

        CreateTableImpl.CreateTableImpl_Step003 step003 = new CreateTableImpl.CreateTableImpl_Step003(parameter);
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
            System.touch("//continue");

                System.set("//database", parameter, PreconditionCheck.class);

                System.set("//database{name}", parameter, PreconditionCheck.class);

            System.touch("//continue");
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.touch("//continue");

                System.set("//database/table", parameter, TaskRunner.class);

                System.set("//database/table{name}", parameter, TaskRunner.class);

            System.touch("//continue");
        }
    }

    public static class PostconditionCheck
    {
        public PostconditionCheck(Parameter parameter) throws Exception
        {
            System.touch("//continue");

                System.set("//database", parameter, PostconditionCheck.class);

                System.set("//database/table{name}", parameter, TaskRunner.class);

            System.touch("//continue");
        }
    }

    public static class Utility
    {
        public static String getDatabaseFile(Parameter parameter)
        {
            return DatabaseConstants.baseURL +"\\"+ getDatabaseName(parameter) + ".sql";
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
            var sqlstring = parameter.sqlstring;

            var tokenizer = new StringTokenizer(sqlstring, " ");

            var token001 = tokenizer.nextToken().toLowerCase();

            var token002 = tokenizer.nextToken().toLowerCase();

            var token003 = tokenizer.nextToken().toLowerCase();

            return token003;
        }
    }
}


