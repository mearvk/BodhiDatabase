package cases;

import system.System;

import java.io.File;

public class InsertIntoImpl extends Case
{
    public InsertIntoImpl.InsertIntoImpl_Step001 step001;

    public InsertIntoImpl.InsertIntoImpl_Step002 step002;

    public InsertIntoImpl.InsertIntoImpl_Step003 step003;

    public InsertIntoImpl.Parameter parameter;

    public InsertIntoImpl(String sqlString)
    {
        System.Memory.reference.push("//insertintoimpl", this);

        //

        this.parameter = new InsertIntoImpl.Parameter(this, sqlString);

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
        public InsertIntoImpl_Step001(InsertIntoImpl.Parameter parameter) throws Exception
        {
            //step 1
        }
    }

    public static class InsertIntoImpl_Step002
    {
        public InsertIntoImpl_Step002(InsertIntoImpl.Parameter parameter) throws Exception
        {
            //step 2
        }
    }

    public static class InsertIntoImpl_Step003
    {
        public InsertIntoImpl_Step003(InsertIntoImpl.Parameter parameter) throws Exception
        {
            //step 3
        }
    }

    public static class Parameter
    {
        public String sqlString;

        public String databasename_uppercase = "";

        public String databasename_lowercase = "";

        public InsertIntoImpl parent;

        public File file;

        public Parameter(InsertIntoImpl parent, String sqlString)
        {
            this.parent = parent;

            this.sqlString = sqlString;
        }
    }
}
