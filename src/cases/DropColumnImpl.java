package cases;

import system.System;

import java.io.File;

public class DropColumnImpl extends Case
{
    public DropColumnImpl.DropColumnImpl_Step001 step001;

    public DropColumnImpl.DropColumnImpl_Step002 step002;

    public DropColumnImpl.DropColumnImpl_Step003 step003;

    public DropColumnImpl.Parameter parameter;

    public DropColumnImpl(String sqlString)
    {
        System.Memory.reference.push("//createtableimpl", this);

        //

        this.parameter = new DropColumnImpl.Parameter(this, sqlString);

        //

        try
        {   this.step001 = new DropColumnImpl.DropColumnImpl_Step001(this.parameter);

            this.step002 = new DropColumnImpl.DropColumnImpl_Step002(this.parameter);

            this.step003 = new DropColumnImpl.DropColumnImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class DropColumnImpl_Step001
    {
        public DropColumnImpl_Step001(DropColumnImpl.Parameter parameter) throws Exception
        {
            //step 1
        }
    }

    public static class DropColumnImpl_Step002
    {
        public DropColumnImpl_Step002(DropColumnImpl.Parameter parameter) throws Exception
        {
            //step 2
        }
    }

    public static class DropColumnImpl_Step003
    {
        public DropColumnImpl_Step003(DropColumnImpl.Parameter parameter) throws Exception
        {
            //step 3
        }
    }

    public static class Parameter
    {
        public String sqlString;

        public String databasename_uppercase = "";

        public String databasename_lowercase = "";

        public DropColumnImpl parent;

        public File file;

        public Parameter(DropColumnImpl parent, String sqlString)
        {
            this.parent = parent;

            this.sqlString = sqlString;
        }
    }
}
