package cases;

import constants.DatabaseConstants;
import parameter.Parameter;
import system.System;

import java.io.File;
import java.util.StringTokenizer;

public class CreateIndexOnTableImpl extends UseCase
{
    public CreateIndexOnTableImpl(String sql_string) throws Exception
    {
        System.pre("//continue");

        //

        Parameter parameter = new Parameter(this, sql_string,CreateIndexOnTableImpl.class);

        //

        CreateIndexImpl_Step001 step001 = new CreateIndexImpl_Step001(parameter);

        CreateIndexImpl_Step002 step002 = new CreateIndexImpl_Step002(parameter);

        CreateIndexImpl_Step003 step003 = new CreateIndexImpl_Step003(parameter);
    }

    public static class CreateIndexImpl_Step001
    {
        public CreateIndexImpl_Step001(Parameter parameter) throws Exception
        {
            PreconditionCheck check = new PreconditionCheck(parameter);
        }
    }

    public static class CreateIndexImpl_Step002
    {
        public CreateIndexImpl_Step002(Parameter parameter) throws Exception
        {
            TaskRunner runner = new TaskRunner(parameter);
        }
    }

    public static class CreateIndexImpl_Step003
    {
        public CreateIndexImpl_Step003(Parameter parameter) throws Exception
        {
            PostconditionCheck check = new PostconditionCheck(parameter);
        }
    }

    public static class PreconditionCheck
    {
        public PreconditionCheck(Parameter parameter) throws Exception
        {
            System.stepper("//database", parameter, UseDatabaseImpl.PreconditionCheck.class);
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.stepper("//database", parameter, UseDatabaseImpl.PreconditionCheck.class);
        }
    }

    public static class PostconditionCheck
    {
        public PostconditionCheck(Parameter parameter) throws Exception
        {
            System.stepper("//database", parameter, UseDatabaseImpl.PreconditionCheck.class);
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
