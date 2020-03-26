package cases;

import system.System;

import java.io.File;

public class CreateIndexImpl extends Case
{
    public CreateIndexImpl.CreateIndexImpl_Step001 step001;

    public CreateIndexImpl.CreateIndexImpl_Step002 step002;

    public CreateIndexImpl.CreateIndexImpl_Step003 step003;

    public CreateIndexImpl.Parameter parameter;

    public CreateIndexImpl(String sqlString)
    {
        System.Memory.reference.push("//createindeximpl", this);

        //

        this.parameter = new CreateIndexImpl.Parameter(this, sqlString);

        //

        try
        {   this.step001 = new CreateIndexImpl.CreateIndexImpl_Step001(this.parameter);

            this.step002 = new CreateIndexImpl.CreateIndexImpl_Step002(this.parameter);

            this.step003 = new CreateIndexImpl.CreateIndexImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class CreateIndexImpl_Step001
    {
        public CreateIndexImpl_Step001(CreateIndexImpl.Parameter parameter) throws Exception
        {
            //step 1
        }
    }

    public static class CreateIndexImpl_Step002
    {
        public CreateIndexImpl_Step002(CreateIndexImpl.Parameter parameter) throws Exception
        {
            //step 2
        }
    }

    public static class CreateIndexImpl_Step003
    {
        public CreateIndexImpl_Step003(CreateIndexImpl.Parameter parameter) throws Exception
        {
            //step 3
        }
    }

    public static class Parameter
    {
        public String sqlString;

        public String databasename_uppercase = "";

        public String databasename_lowercase = "";

        public CreateIndexImpl parent;

        public File file;

        public Parameter(CreateIndexImpl parent, String sqlString)
        {
            this.parent = parent;

            this.sqlString = sqlString;
        }
    }
}
