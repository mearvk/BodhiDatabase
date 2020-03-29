package cases;

import parameter.Parameter;
import system.System;

import java.util.StringTokenizer;

public class SelectImpl extends UseCase
{
    public SelectImpl.SelectImpl_Step001 step001;

    public SelectImpl.SelectImpl_Step002 step002;

    public SelectImpl.SelectImpl_Step003 step003;

    public Parameter parameter;

    public SelectImpl(String sqlString)
    {
        System.push("//impl/select", this);

        //

        this.parameter = new Parameter(this, sqlString);

        //

        try
        {   this.step001 = new SelectImpl.SelectImpl_Step001(this.parameter);

            this.step002 = new SelectImpl.SelectImpl_Step002(this.parameter);

            this.step003 = new SelectImpl.SelectImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class SelectImpl_Step001
    {
        public SelectImpl_Step001(Parameter parameter) throws Exception
        {
            System.touch("//database");
        }
    }

    public static class SelectImpl_Step002
    {
        public SelectImpl_Step002(Parameter parameter) throws Exception
        {
            System.push("//result", System.database.reader.select(parameter));
        }
    }

    public static class SelectImpl_Step003
    {
        public SelectImpl_Step003(Parameter parameter) throws Exception
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
