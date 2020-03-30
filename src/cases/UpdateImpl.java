package cases;

import components.database.DatabaseComponent;
import parameter.Parameter;
import system.System;

import java.util.StringTokenizer;

public class UpdateImpl extends UseCase
{
    public UpdateImpl.UpdateImpl_Step001 step001;

    public UpdateImpl.UpdateImpl_Step002 step002;

    public UpdateImpl.UpdateImpl_Step003 step003;

    public Parameter parameter;

    public UpdateImpl(String sqlString) throws Exception
    {
        System.push("//impl/update", this);

        //

        this.parameter = new Parameter(this, sqlString);

        //

        try
        {   this.step001 = new UpdateImpl.UpdateImpl_Step001(this.parameter);

            this.step002 = new UpdateImpl.UpdateImpl_Step002(this.parameter);

            this.step003 = new UpdateImpl.UpdateImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class UpdateImpl_Step001
    {
        public UpdateImpl_Step001(Parameter parameter) throws Exception
        {
            //step 1
        }
    }

    public static class UpdateImpl_Step002
    {
        public UpdateImpl_Step002(Parameter parameter) throws Exception
        {
            //step 2
        }
    }

    public static class UpdateImpl_Step003
    {
        public UpdateImpl_Step003(Parameter parameter) throws Exception
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
            DatabaseComponent databaseComponent = (DatabaseComponent)System.pull("//database");

            return databaseComponent.name;
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
}
