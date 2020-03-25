package components.cases;

import system.System;

import java.io.File;

public class UpdateImpl
{
    public UpdateImpl.UpdateImpl_Step001 step001;

    public UpdateImpl.UpdateImpl_Step002 step002;

    public UpdateImpl.UpdateImpl_Step003 step003;

    public UpdateImpl.Parameter parameter;

    public UpdateImpl(String sqlString)
    {
        System.Memory.reference.push("//updateimpl", this);

        //

        this.parameter = new UpdateImpl.Parameter(this, sqlString);

        //

        try
        {   this.step001 = new UpdateImpl.UpdateImpl_Step001(this.parameter);

            this.step002 = new UpdateImpl.UpdateImpl_Step002(this.parameter);

            this.step003 = new UpdateImpl.UpdateImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class UpdateImpl_Step001
    {
        public UpdateImpl_Step001(UpdateImpl.Parameter parameter) throws Exception
        {
            //step 1
        }
    }

    public static class UpdateImpl_Step002
    {
        public UpdateImpl_Step002(UpdateImpl.Parameter parameter) throws Exception
        {
            //step 2
        }
    }

    public static class UpdateImpl_Step003
    {
        public UpdateImpl_Step003(UpdateImpl.Parameter parameter) throws Exception
        {
            //step 3
        }
    }

    public static class Parameter
    {
        public String sqlString;

        public String databasename_uppercase = "";

        public String databasename_lowercase = "";

        public UpdateImpl parent;

        public File file;

        public Parameter(UpdateImpl parent, String sqlString)
        {
            this.parent = parent;

            this.sqlString = sqlString;
        }
    }
}
