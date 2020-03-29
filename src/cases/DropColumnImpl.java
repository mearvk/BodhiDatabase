package cases;

import parameter.Parameter;
import system.System;

public class DropColumnImpl extends UseCase
{
    public DropColumnImpl.DropColumnImpl_Step001 step001;

    public DropColumnImpl.DropColumnImpl_Step002 step002;

    public DropColumnImpl.DropColumnImpl_Step003 step003;

    public Parameter parameter;

    public DropColumnImpl(String sqlString)
    {
        System.push("//impl/dropcolumn", this);

        //

        this.parameter = new Parameter(this, sqlString);

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
        public DropColumnImpl_Step001(Parameter parameter) throws Exception
        {
            System.touch("//database");
        }
    }

    public static class DropColumnImpl_Step002
    {
        public DropColumnImpl_Step002(Parameter parameter) throws Exception
        {
            System.database.writer.drop_columns(parameter);
        }
    }

    public static class DropColumnImpl_Step003
    {
        public DropColumnImpl_Step003(Parameter parameter) throws Exception
        {
            System.touch("//database");
        }
    }
}
