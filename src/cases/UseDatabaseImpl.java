package cases;

import constants.DatabaseConstants;
import parameter.Parameter;
import system.System;

import java.util.StringTokenizer;

public class UseDatabaseImpl extends UseCase
{
    public UseDatabaseImpl_Step001 step001;

    public UseDatabaseImpl_Step002 step002;

    public UseDatabaseImpl_Step003 step003;

    public Parameter parameter;

    public UseDatabaseImpl(String sqlString) throws Exception
    {
        System.pre("//continue");

        //

        Parameter parameter = new Parameter(this, sqlString);

        //

        try
        {
            this.step001 = new UseDatabaseImpl_Step001(this.parameter);

            this.step002 = new UseDatabaseImpl_Step002(this.parameter);

            this.step003 = new UseDatabaseImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
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
            System.set("//database", parameter, UseDatabaseImpl.PreconditionCheck.class);
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.set("//database", parameter, UseDatabaseImpl.PreconditionCheck.class);
        }
    }

    public static class PostconditionCheck
    {
        public PostconditionCheck(Parameter parameter) throws Exception
        {
            System.set("//database", parameter, UseDatabaseImpl.PreconditionCheck.class);
        }
    }

    public static class Utility
    {
        public static String getDatabaseUrl(Parameter parameter)
        {
            return DatabaseConstants.baseURL +"\\"+ parameter.name + ".sql";
        }

        public static String getDatabaseName(Parameter parameter)
        {
            String sqlstring = parameter.sqlstring;

            StringTokenizer tokenizer = new StringTokenizer(sqlstring, " ");

            String token001 = tokenizer.nextToken().toLowerCase();

            String token002 = tokenizer.nextToken().toLowerCase();

            return token002;
        }
    }
}
