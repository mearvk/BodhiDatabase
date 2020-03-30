package cases;

import parameter.Parameter;
import system.System;

public class CreateTableImpl extends UseCase
{
    public CreateTableImpl.CreateTableImpl_Step001 step001;

    public CreateTableImpl.CreateTableImpl_Step002 step002;

    public CreateTableImpl.CreateTableImpl_Step003 step003;

    public Parameter parameter;

    public CreateTableImpl(String sqlstring) throws Exception
    {
        System.push("//impl/createtable", this);

        //

        this.parameter = new Parameter(this, sqlstring);

        //

        try
        {
            this.step001 = new CreateTableImpl.CreateTableImpl_Step001(this.parameter);

            this.step002 = new CreateTableImpl.CreateTableImpl_Step002(this.parameter);

            this.step003 = new CreateTableImpl.CreateTableImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public static class CreateTableImpl_Step001
    {
        public CreateTableImpl_Step001(Parameter parameter) throws Exception
        {
            System.push("//step001", new PreConditionRunner(parameter));
        }
    }

    public static class CreateTableImpl_Step002
    {
        public CreateTableImpl_Step002(Parameter parameter) throws Exception
        {
            System.push("//step002", new TaskRunner(parameter));
        }
    }

    public static class CreateTableImpl_Step003
    {
        public CreateTableImpl_Step003(Parameter parameter) throws Exception
        {
            System.push("//step003", new PostConditionRunner(parameter));
        }
    }

    public static class PreConditionRunner
    {
        public PreConditionRunner(Parameter parameter) throws Exception
        {
            System.touch("//database");
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {

        }
    }

    public static class PostConditionRunner
    {
        public PostConditionRunner(Parameter parameter) throws Exception
        {
            System.touch("//database");
        }
    }
}


