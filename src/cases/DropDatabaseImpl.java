package cases;

import system.System;

import java.io.File;

public class DropDatabaseImpl extends Case
{
    public DropDatabaseImpl.DropDatabaseImpl_Step001 step001;

    public DropDatabaseImpl.DropDatabaseImpl_Step002 step002;

    public DropDatabaseImpl.DropDatabaseImpl_Step003 step003;

    public DropDatabaseImpl.Parameter parameter;

    public DropDatabaseImpl(String sqlString)
    {
        System.Memory.reference.push("//createtableimpl", this);

        //

        this.parameter = new DropDatabaseImpl.Parameter(this, sqlString);

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
        public DropDatabaseImpl_Step001(DropDatabaseImpl.Parameter parameter) throws Exception
        {
            //step 1
        }
    }

    public static class DropDatabaseImpl_Step002
    {
        public DropDatabaseImpl_Step002(DropDatabaseImpl.Parameter parameter) throws Exception
        {
            //step 2
        }
    }

    public static class DropDatabaseImpl_Step003
    {
        public DropDatabaseImpl_Step003(DropDatabaseImpl.Parameter parameter) throws Exception
        {
            //step 3
        }
    }

    public static class Parameter
    {
        public String sqlString;

        public String databasename_uppercase = "";

        public String databasename_lowercase = "";

        public DropDatabaseImpl parent;

        public File file;

        public Parameter(DropDatabaseImpl parent, String sqlString)
        {
            this.parent = parent;

            this.sqlString = sqlString;
        }
    }
}
