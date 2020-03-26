package cases;

import system.System;

import java.io.File;

public class CreateTableImpl
{
    public CreateTableImpl.CreateTableImpl_Step001 step001;

    public CreateTableImpl.CreateTableImpl_Step002 step002;

    public CreateTableImpl.CreateTableImpl_Step003 step003;

    public CreateTableImpl.Parameter parameter;

    public CreateTableImpl(String sqlString)
    {
        System.Memory.reference.push("//createtableimpl", this);

        //

        this.parameter = new CreateTableImpl.Parameter(this, sqlString);

        //

        try
        {   this.step001 = new CreateTableImpl.CreateTableImpl_Step001(this.parameter);

            this.step002 = new CreateTableImpl.CreateTableImpl_Step002(this.parameter);

            this.step003 = new CreateTableImpl.CreateTableImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class CreateTableImpl_Step001
    {
        public CreateTableImpl_Step001(CreateTableImpl.Parameter parameter) throws Exception
        {
            //step 1
        }
    }

    public static class CreateTableImpl_Step002
    {
        public CreateTableImpl_Step002(CreateTableImpl.Parameter parameter) throws Exception
        {
            //step 2
        }
    }

    public static class CreateTableImpl_Step003
    {
        public CreateTableImpl_Step003(CreateTableImpl.Parameter parameter) throws Exception
        {
            //step 3
        }
    }

    public static class Parameter
    {
        public String sqlString;

        public String databasename_uppercase = "";

        public String databasename_lowercase = "";

        public CreateTableImpl parent;

        public File file;

        public Parameter(CreateTableImpl parent, String sqlString)
        {
            this.parent = parent;

            this.sqlString = sqlString;
        }
    }
}
