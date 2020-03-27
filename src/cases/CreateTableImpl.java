package cases;

import constants.DatabaseConstants;
import parameter.Parameter;
import structures.database.Database;
import structures.database.handler.DatabaseHandler;
import system.System;

import java.util.StringTokenizer;

public class CreateTableImpl extends UseCase
{
    public CreateTableImpl.CreateTableImpl_Step001 step001;

    public CreateTableImpl.CreateTableImpl_Step002 step002;

    public CreateTableImpl.CreateTableImpl_Step003 step003;

    public Parameter parameter;

    public CreateTableImpl(String sqlstring) throws Exception
    {
        System.Memory.reference.push("//impl/createtable", this);

        //

        this.parameter = new Parameter(this, sqlstring);

        //

        try
        {
            this.step001 = new CreateTableImpl.CreateTableImpl_Step001(this.parameter);

            this.step002 = new CreateTableImpl.CreateTableImpl_Step002(this.parameter);

            this.step003 = new CreateTableImpl.CreateTableImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public static class CreateTableImpl_Step001
    {
        public CreateTableImpl_Step001(Parameter parameter) throws Exception
        {
            System.Memory.reference.push("//step001", new PreConditionRunner(parameter));
        }
    }

    public static class CreateTableImpl_Step002
    {
        public CreateTableImpl_Step002(Parameter parameter) throws Exception
        {
            System.Memory.reference.push("//step002", new TaskRunner(parameter));
        }
    }

    public static class CreateTableImpl_Step003
    {
        public CreateTableImpl_Step003(Parameter parameter) throws Exception
        {
            System.Memory.reference.push("//step003", new PostConditionRunner(parameter));
        }
    }

    public static class Utility
    {
        public CreateTableImpl parent;

        public String sqlString;

        public Utility(CreateTableImpl parent, String sqlString)
        {
            this.parent = parent;

            this.sqlString = sqlString;
        }

        public static String getDatabaseUrl(Parameter parameter)
        {
            return DatabaseConstants.baseURL+"\\"+parameter.database_name +".sql";
        }

        public static String getDatabaseName(Parameter parameter)
        {
            return ((Database)System.Memory.reference.pull("//database")).name;
        }

        public static String getTableName(Parameter parameter)
        {
            String sqlString = parameter.sqlstring;

            StringTokenizer tokenizer = new StringTokenizer(sqlString, " ");

            String token001 = tokenizer.nextToken();

            String token002 = tokenizer.nextToken();

            String token003 = tokenizer.nextToken();

            return token003;
        }
    }

    public static class PreConditionRunner
    {
        public PreConditionRunner(Parameter parameter) throws Exception
        {
            System.handler.reference.database_exists(parameter);

            System.handler.reference.table_exists(parameter);
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.handler.reference.createTable(parameter);
        }
    }

    public static class PostConditionRunner
    {
        public PostConditionRunner(Parameter parameter) throws Exception
        {
            System.handler.reference.verifyTable(parameter);
        }
    }
}


