package cases;

import components.database.DatabaseComponent;
import constants.DatabaseConstants;
import contexts.UseImplContext;
import parameter.Parameter;
import system.System;

import java.util.StringTokenizer;

public class UseDatabaseImpl extends UseCase
{
    public UseDatabaseImpl.UseImpl_Step001 step001;

    public UseDatabaseImpl.UseImpl_Step002 step002;

    public UseDatabaseImpl.UseImpl_Step003 step003;

    public Parameter parameter;

    public UseDatabaseImpl(String sqlString) throws Exception
    {
        this.parameter = new Parameter(this, sqlString);

        //

        try
        {
            this.step001 = new UseDatabaseImpl.UseImpl_Step001(this.parameter);

            this.step002 = new UseDatabaseImpl.UseImpl_Step002(this.parameter);

            this.step003 = new UseDatabaseImpl.UseImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class UseImpl_Step001
    {
        public UseImpl_Step001(Parameter parameter) throws Exception
        {
            System.push("//step001", new PreconditionCheck(parameter));
        }
    }

    public static class UseImpl_Step002
    {
        public UseImpl_Step002(Parameter parameter) throws Exception
        {
            System.push("//step002", new TaskRunner(parameter));
        }
    }

    public static class UseImpl_Step003
    {
        public UseImpl_Step003(Parameter parameter) throws Exception
        {
            System.push("//step003", new PostconditionCheck(parameter));
        }
    }

    public static class PreconditionCheck
    {
        public PreconditionCheck(Parameter parameter) throws Exception
        {
            return;
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            return;
        }
    }

    public static class PostconditionCheck
    {
        public PostconditionCheck(Parameter parameter) throws Exception
        {
            return;
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
            String sqlstring = parameter.sqlstring;

            StringTokenizer tokenizer = new StringTokenizer(sqlstring, " ");

            String token001 = tokenizer.nextToken().toLowerCase();

            String token002 = tokenizer.nextToken().toLowerCase();

            return token002;
        }
    }
}
