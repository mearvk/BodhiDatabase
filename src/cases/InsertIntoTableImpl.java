package cases;

import parameter.Parameter;
import system.System;

import java.util.StringTokenizer;

public class InsertIntoTableImpl extends UseCase
{
    public InsertIntoTableImpl.InsertIntoImpl_Step001 step001;

    public InsertIntoTableImpl.InsertIntoImpl_Step002 step002;

    public InsertIntoTableImpl.InsertIntoImpl_Step003 step003;

    public Parameter parameter;

    public InsertIntoTableImpl(String sqlString) throws Exception
    {
        System.push("//impl/insertinto", this);

        //

        this.parameter = new Parameter(this, sqlString);

        //

        try
        {   this.step001 = new InsertIntoTableImpl.InsertIntoImpl_Step001(this.parameter);

            this.step002 = new InsertIntoTableImpl.InsertIntoImpl_Step002(this.parameter);

            this.step003 = new InsertIntoTableImpl.InsertIntoImpl_Step003(this.parameter);
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
            System.touch("//database");
        }
    }

    public static class InsertIntoImpl_Step002
    {
        public InsertIntoImpl_Step002(Parameter parameter) throws Exception
        {
            //System.database.writer.insert_into(parameter);
        }
    }

    public static class InsertIntoImpl_Step003
    {
        public InsertIntoImpl_Step003(Parameter parameter) throws Exception
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
