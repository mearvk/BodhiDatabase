package cases;

import parameter.Parameter;
import system.System;

import java.util.StringTokenizer;

public class DeleteFromImpl extends UseCase
{
    public DeleteFromImpl.DeleteFromImpl_Step001 step001;

    public DeleteFromImpl.DeleteFromImpl_Step002 step002;

    public DeleteFromImpl.DeleteFromImpl_Step003 step003;

    public Parameter parameter;

    public DeleteFromImpl(String sqlString)
    {
        System.Memory.reference.push("//createtableimpl", this);

        //

        this.parameter = new Parameter(this, sqlString);

        //

        try
        {   this.step001 = new DeleteFromImpl.DeleteFromImpl_Step001(this.parameter);

            this.step002 = new DeleteFromImpl.DeleteFromImpl_Step002(this.parameter);

            this.step003 = new DeleteFromImpl.DeleteFromImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class DeleteFromImpl_Step001
    {
        public DeleteFromImpl_Step001(Parameter parameter) throws Exception
        {
            //step 1
        }
    }

    public static class DeleteFromImpl_Step002
    {
        public DeleteFromImpl_Step002(Parameter parameter) throws Exception
        {
            //step 2
        }
    }

    public static class DeleteFromImpl_Step003
    {
        public DeleteFromImpl_Step003(Parameter parameter) throws Exception
        {
            //step 3
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
