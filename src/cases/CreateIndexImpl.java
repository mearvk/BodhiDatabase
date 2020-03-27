package cases;

import parameter.Parameter;
import system.System;

public class CreateIndexImpl extends UseCase
{
    public CreateIndexImpl.CreateIndexImpl_Step001 step001;

    public CreateIndexImpl.CreateIndexImpl_Step002 step002;

    public CreateIndexImpl.CreateIndexImpl_Step003 step003;

    public Parameter parameter;

    public CreateIndexImpl(String sqlString)
    {
        System.Memory.reference.push("//createindeximpl", this);

        //

        this.parameter = new Parameter(this, sqlString);

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
        public CreateIndexImpl_Step001(Parameter parameter) throws Exception
        {
            System.drop("//database");
        }
    }

    public static class CreateIndexImpl_Step002
    {
        public CreateIndexImpl_Step002(Parameter parameter) throws Exception
        {
            //TODO JSON in RAM and output option
        }
    }

    public static class CreateIndexImpl_Step003
    {
        public CreateIndexImpl_Step003(Parameter parameter) throws Exception
        {
            System.drop("//database");
        }
    }
}
