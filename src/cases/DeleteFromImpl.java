package cases;

import parameter.Parameter;
import system.System;

public class DeleteFromImpl extends UseCase
{
    public DeleteFromImpl.DeleteFromImpl_Step001 step001;

    public DeleteFromImpl.DeleteFromImpl_Step002 step002;

    public DeleteFromImpl.DeleteFromImpl_Step003 step003;

    public Parameter parameter;

    public DeleteFromImpl(String sqlString)
    {
        System.Memory.reference.push("//createtableimpl", this);

        //

        this.parameter = new Parameter(this, sqlString);

        //

        try
        {   this.step001 = new DeleteFromImpl.DeleteFromImpl_Step001(this.parameter);

            this.step002 = new DeleteFromImpl.DeleteFromImpl_Step002(this.parameter);

            this.step003 = new DeleteFromImpl.DeleteFromImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class DeleteFromImpl_Step001
    {
        public DeleteFromImpl_Step001(Parameter parameter) throws Exception
        {
            System.push("//step001", new PreConditionRunner(parameter));
        }
    }

    public static class DeleteFromImpl_Step002
    {
        public DeleteFromImpl_Step002(Parameter parameter) throws Exception
        {
            System.push("//step002", new TaskRunner(parameter));
        }
    }

    public static class DeleteFromImpl_Step003
    {
        public DeleteFromImpl_Step003(Parameter parameter) throws Exception
        {
            System.push("//step00\3", new PostConditionRunner(parameter));
        }
    }

    public static class PreConditionRunner
    {
        public PreConditionRunner(Parameter parameter) throws Exception
        {
            System.drop("//database");
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.handler.writer.tablewriter(parameter);
        }
    }

    public static class PostConditionRunner
    {
        public PostConditionRunner(Parameter parameter) throws Exception
        {
            System.drop("//database");
        }
    }
}
