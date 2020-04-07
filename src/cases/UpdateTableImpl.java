package cases;

import components.database.Database;
import parameter.Parameter;
import system.System;

import java.util.StringTokenizer;

public class UpdateTableImpl extends UseCase
{
    public UpdateTableImpl(String sql_string) throws Exception
    {
        System.pre("//continue");

        //

        Parameter parameter = new Parameter(this, sql_string, UpdateTableImpl.class);

        //

        new UpdateTableImpl_Step001(parameter);

        new UpdateTableImpl_Step002(parameter);

        new UpdateTableImpl_Step003(parameter);
    }

    public static class UpdateTableImpl_Step001
    {
        public UpdateTableImpl_Step001(Parameter parameter) throws Exception
        {
            //step 1
        }
    }

    public static class UpdateTableImpl_Step002
    {
        public UpdateTableImpl_Step002(Parameter parameter) throws Exception
        {
            //step 2
        }
    }

    public static class UpdateTableImpl_Step003
    {
        public UpdateTableImpl_Step003(Parameter parameter) throws Exception
        {
            //step 3
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

        public static String getDatabaseName(Parameter parameter) throws Exception
        {
            Database database = (Database)System.storage("//database");

            return database.name;
        }

        public static String getTableName(Parameter parameter)
        {
            String sqlString = parameter.sql_string;

            StringTokenizer tokenizer = new StringTokenizer(sqlString, " ");

            String token001 = tokenizer.nextToken();

            String token002 = tokenizer.nextToken();

            String token003 = tokenizer.nextToken();

            return token003;
        }

    }
}
