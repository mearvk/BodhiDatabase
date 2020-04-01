package cases;

import parameter.Parameter;
import system.System;

public class DropColumnImpl extends UseCase
{
    public Parameter parameter;

    public DropColumnImpl(String sqlString) throws Exception
    {
        System.pre("//continue");

        //

        Parameter parameter = new Parameter(this, sqlString);

        //

        DropColumnImpl.DropColumnImpl_Step001 step001 = new DropColumnImpl.DropColumnImpl_Step001(this.parameter);

        DropColumnImpl.DropColumnImpl_Step002 step002 = new DropColumnImpl.DropColumnImpl_Step002(this.parameter);

        DropColumnImpl.DropColumnImpl_Step003 step003 = new DropColumnImpl.DropColumnImpl_Step003(this.parameter);

    }

    public static class DropColumnImpl_Step001
    {
        public DropColumnImpl_Step001(Parameter parameter) throws Exception
        {
            PreconditionCheck check = new PreconditionCheck(parameter);
        }
    }

    public static class DropColumnImpl_Step002
    {
        public DropColumnImpl_Step002(Parameter parameter) throws Exception
        {
            TaskRunner runner = new TaskRunner(parameter);
        }
    }

    public static class DropColumnImpl_Step003
    {
        public DropColumnImpl_Step003(Parameter parameter) throws Exception
        {
            PostconditionCheck check = new PostconditionCheck(parameter);
        }
    }

    public static class PreconditionCheck
    {
        public PreconditionCheck(Parameter parameter) throws Exception
        {
            System.touch("//continue");

                System.set("//database", parameter, DeleteFromImpl.PreconditionCheck.class);

            System.touch("//continue");
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.touch("//continue");

                System.set("//database", parameter, DeleteFromImpl.TaskRunner.class);

            System.touch("//continue");
        }
    }

    public static class PostconditionCheck
    {
        public PostconditionCheck(Parameter parameter) throws Exception
        {
            System.touch("//continue");

                System.set("//database", parameter, DeleteFromImpl.PostconditionCheck.class);

            System.touch("//continue");
        }
    }
}
