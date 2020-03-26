package cases;

import system.System;

import java.io.File;

public class DeleteFromImpl
{
    public DeleteFromImpl.DeleteFromImpl_Step001 step001;

    public DeleteFromImpl.DeleteFromImpl_Step002 step002;

    public DeleteFromImpl.DeleteFromImpl_Step003 step003;

    public DeleteFromImpl.Parameter parameter;

    public DeleteFromImpl(String sqlString)
    {
        System.Memory.reference.push("//createtableimpl", this);

        //

        this.parameter = new DeleteFromImpl.Parameter(this, sqlString);

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
        public DeleteFromImpl_Step001(DeleteFromImpl.Parameter parameter) throws Exception
        {
            //step 1
        }
    }

    public static class DeleteFromImpl_Step002
    {
        public DeleteFromImpl_Step002(DeleteFromImpl.Parameter parameter) throws Exception
        {
            //step 2
        }
    }

    public static class DeleteFromImpl_Step003
    {
        public DeleteFromImpl_Step003(DeleteFromImpl.Parameter parameter) throws Exception
        {
            //step 3
        }
    }

    public static class Parameter
    {
        public String sqlString;

        public String databasename_uppercase = "";

        public String databasename_lowercase = "";

        public DeleteFromImpl parent;

        public File file;

        public Parameter(DeleteFromImpl parent, String sqlString)
        {
            this.parent = parent;

            this.sqlString = sqlString;
        }
    }
}
