package cases;

import parameter.Parameter;
import system.System;

public class DeleteFromImpl extends UseCase
{
    public DeleteFromImpl(String sql_string) throws Exception
    {
        System.pre("//continue");

        //

        Parameter parameter = new Parameter(this, sql_string, DeleteFromImpl.class);

        //

        new DeleteFromImpl.DeleteFromImpl_Step001(parameter);

        new DeleteFromImpl.DeleteFromImpl_Step002(parameter);

        new DeleteFromImpl.DeleteFromImpl_Step003(parameter);
    }

    public static class DeleteFromImpl_Step001
    {
        public DeleteFromImpl_Step001(Parameter parameter) throws Exception
        {
            PreconditionCheck check =  new PreconditionCheck(parameter);
        }
    }

    public static class DeleteFromImpl_Step002
    {
        public DeleteFromImpl_Step002(Parameter parameter) throws Exception
        {
            TaskRunner runner = new TaskRunner(parameter);
        }
    }

    public static class DeleteFromImpl_Step003
    {
        public DeleteFromImpl_Step003(Parameter parameter) throws Exception
        {
            PostconditionCheck check = new PostconditionCheck(parameter);
        }
    }

    public static class PreconditionCheck
    {
        public PreconditionCheck(Parameter parameter) throws Exception
        {
            System.hook("//continue");

                System.stepper("//database", parameter, DeleteFromImpl.PreconditionCheck.class);

            System.hook("//continue");
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.hook("//continue");

                System.stepper("//database", parameter, DeleteFromImpl.TaskRunner.class);

            System.hook("//continue");
        }
    }

    public static class PostconditionCheck
    {
        public PostconditionCheck(Parameter parameter) throws Exception
        {
            System.hook("//continue");

                System.stepper("//database", parameter, DeleteFromImpl.PostconditionCheck.class);

            System.hook("//continue");
        }
    }
}
