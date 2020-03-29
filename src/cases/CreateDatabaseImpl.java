package cases;

import constants.DatabaseConstants;
import contexts.CreateDatabaseImplContext;
import parameter.Parameter;
import system.System;

import java.util.StringTokenizer;

public class CreateDatabaseImpl extends UseCase
{
    public CreateDatabaseImpl_Step001 step001;

    public CreateDatabaseImpl_Step002 step002;

    public CreateDatabaseImpl_Step003 step003;

    public Parameter parameter;

    public CreateDatabaseImpl(String sqlString)
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
            System.validation.touch("//database", parameter, CreateDatabaseImplContext.class);
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.processor.set("//database", parameter, CreateDatabaseImplContext.class);
        }
    }

    public static class PostConditionRunner
    {
        public PostConditionRunner(Parameter parameter) throws Exception
        {
            boolean result = System.database.reader.database_exists(parameter);
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

