package cases;

import parameter.Parameter;
import system.System;

public class DeleteFromImpl extends UseCase
{
    public DeleteFromImpl(String sqlString) throws Exception
    {
        System.pre("//continue");

        //

        Parameter parameter = new Parameter(this, sqlString);

        //

        DeleteFromImpl.DeleteFromImpl_Step001 step001 = new DeleteFromImpl.DeleteFromImpl_Step001(parameter);

        DeleteFromImpl.DeleteFromImpl_Step002 step002 = new DeleteFromImpl.DeleteFromImpl_Step002(parameter);

        DeleteFromImpl.DeleteFromImpl_Step003 step003 = new DeleteFromImpl.DeleteFromImpl_Step003(parameter);
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
            System.touch("//continue");

                System.step("//database", parameter, DeleteFromImpl.PreconditionCheck.class);

            System.touch("//continue");
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.touch("//continue");

                System.step("//database", parameter, DeleteFromImpl.TaskRunner.class);

            System.touch("//continue");
        }
    }

    public static class PostconditionCheck
    {
        public PostconditionCheck(Parameter parameter) throws Exception
        {
            System.touch("//continue");

                System.step("//database", parameter, DeleteFromImpl.PostconditionCheck.class);

            System.touch("//continue");
        }
    }
}
