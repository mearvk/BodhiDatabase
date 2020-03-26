package cases;

import system.System;

import java.io.File;

public class SelectImpl
{
    public SelectImpl.SelectImpl_Step001 step001;

    public SelectImpl.SelectImpl_Step002 step002;

    public SelectImpl.SelectImpl_Step003 step003;

    public SelectImpl.Parameter parameter;

    public SelectImpl(String sqlString)
    {
        System.Memory.reference.push("//selectimpl", this);

        //

        this.parameter = new SelectImpl.Parameter(this, sqlString);

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
        public SelectImpl_Step001(SelectImpl.Parameter parameter) throws Exception
        {
            //step 1
        }
    }

    public static class SelectImpl_Step002
    {
        public SelectImpl_Step002(SelectImpl.Parameter parameter) throws Exception
        {
            //step 2
        }
    }

    public static class SelectImpl_Step003
    {
        public SelectImpl_Step003(SelectImpl.Parameter parameter) throws Exception
        {
            //step 3
        }
    }

    public static class Parameter
    {
        public String sqlString;

        public String databasename_uppercase = "";

        public String databasename_lowercase = "";

        public SelectImpl parent;

        public File file;

        public Parameter(SelectImpl parent, String sqlString)
        {
            this.parent = parent;

            this.sqlString = sqlString;
        }
    }
}
