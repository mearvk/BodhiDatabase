package cases;

import parameter.Parameter;
import system.System;

import java.util.StringTokenizer;

public class DropDatabaseImpl extends UseCase
{
    public DropDatabaseImpl.DropDatabaseImpl_Step001 step001;

    public DropDatabaseImpl.DropDatabaseImpl_Step002 step002;

    public DropDatabaseImpl.DropDatabaseImpl_Step003 step003;

    public Parameter parameter;

    public DropDatabaseImpl(String sqlString)
    {
        System.push("//impl/dropdatabase", this);

        //

        this.parameter = new Parameter(this, sqlString);

        //

        try
        {   this.step001 = new DropDatabaseImpl.DropDatabaseImpl_Step001(this.parameter);

            this.step002 = new DropDatabaseImpl.DropDatabaseImpl_Step002(this.parameter);

            this.step003 = new DropDatabaseImpl.DropDatabaseImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class DropDatabaseImpl_Step001
    {
        public DropDatabaseImpl_Step001(Parameter parameter) throws Exception
        {
            System.touch("//database");
        }
    }

    public static class DropDatabaseImpl_Step002
    {
        public DropDatabaseImpl_Step002(Parameter parameter) throws Exception
        {
            System.database.writer.drop_database(parameter);
        }
    }

    public static class DropDatabaseImpl_Step003
    {
        public DropDatabaseImpl_Step003(Parameter parameter) throws Exception
        {
            System.touch("//database");
        }
    }

    public static class Utility
    {
        public Utility(CreateDatabaseImpl parent, String sqlString)
        {

        }

        public static String getDatabaseName(Parameter parameter)
        {
            String sqlString = parameter.sqlstring;

            StringTokenizer tokenizer = new StringTokenizer(sqlString, " ");

            String token001 = tokenizer.nextToken();

            String token002 = tokenizer.nextToken();

            String token003 = tokenizer.nextToken();

            if(token003==null) return null;

            return token003;
        }
    }
}
