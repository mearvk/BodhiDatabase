package cases;

import constants.DatabaseConstants;
import parameter.Parameter;
import system.System;

import java.io.File;
import java.util.StringTokenizer;

public class UseDatabaseImpl extends UseCase
{
    public UseDatabaseImpl(String sql_string) throws Exception
    {
        System.pre("//continue");

        //

        Parameter parameter = new Parameter(this, sql_string, UseDatabaseImpl.class);

        //

        new UseDatabaseImpl_Step001(parameter);

        new UseDatabaseImpl_Step002(parameter);

        new UseDatabaseImpl_Step003(parameter);
    }

    public static class UseDatabaseImpl_Step001
    {
        public UseDatabaseImpl_Step001(Parameter parameter) throws Exception
        {
            PreconditionCheck check = new PreconditionCheck(parameter);
        }
    }

    public static class UseDatabaseImpl_Step002
    {
        public UseDatabaseImpl_Step002(Parameter parameter) throws Exception
        {
            TaskRunner runner = new TaskRunner(parameter);
        }
    }

    public static class UseDatabaseImpl_Step003
    {
        public UseDatabaseImpl_Step003(Parameter parameter) throws Exception
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
            System.stepper("//database", parameter, UseDatabaseImpl.TaskRunner.class);
        }
    }

    public static class PostconditionCheck
    {
        public PostconditionCheck(Parameter parameter) throws Exception
        {
            System.stepper("//database", parameter, UseDatabaseImpl.PostconditionCheck.class);
        }
    }

    public static class Utility
    {
        public static String getDatabaseUrl(Parameter parameter)
        {
            return DatabaseConstants.baseURL +"\\"+ parameter.database_name + ".sql";
        }

        public static String getDatabaseExists(Parameter parameter)
        {
            try
            {
                return new File(DatabaseConstants.baseURL+"\\"+parameter.database_name +".sql").exists() ? "true" : "false";
            }
            catch(Exception e)
            {
                 return "false";
            }
        }

        public static String getDatabaseName(Parameter parameter)
        {
            String sqlstring = parameter.sql_string;

            StringTokenizer tokenizer = new StringTokenizer(sqlstring, " ");

            String token001 = tokenizer.nextToken().toLowerCase();

            String token002 = tokenizer.nextToken().toLowerCase();

            return token002;
        }
    }
}
