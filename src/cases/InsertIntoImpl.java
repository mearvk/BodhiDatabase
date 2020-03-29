package cases;

import parameter.Parameter;
import system.System;

import java.util.StringTokenizer;

public class InsertIntoImpl extends UseCase
{
    public InsertIntoImpl.InsertIntoImpl_Step001 step001;

    public InsertIntoImpl.InsertIntoImpl_Step002 step002;

    public InsertIntoImpl.InsertIntoImpl_Step003 step003;

    public Parameter parameter;

    public InsertIntoImpl(String sqlString)
    {
        System.Memory.reference.push("//impl/insertinto", this);

        //

        this.parameter = new Parameter(this, sqlString);

        //

        try
        {   this.step001 = new InsertIntoImpl.InsertIntoImpl_Step001(this.parameter);

            this.step002 = new InsertIntoImpl.InsertIntoImpl_Step002(this.parameter);

            this.step003 = new InsertIntoImpl.InsertIntoImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class InsertIntoImpl_Step001
    {
        public InsertIntoImpl_Step001(Parameter parameter) throws Exception
        {
            System.tattle("//database");
        }
    }

    public static class InsertIntoImpl_Step002
    {
        public InsertIntoImpl_Step002(Parameter parameter) throws Exception
        {
            System.database.writer.insert_into(parameter);
        }
    }

    public static class InsertIntoImpl_Step003
    {
        public InsertIntoImpl_Step003(Parameter parameter) throws Exception
        {
            System.tattle("//database");
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
