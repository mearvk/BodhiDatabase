package cases;

import parameter.Parameter;
import system.System;

import java.util.StringTokenizer;

public class DropColumnImpl extends UseCase
{
    public DropColumnImpl(String sqlString) throws Exception
    {
        System.pre("//continue");

        //

        Parameter parameter = new Parameter(this, sqlString);

        //

        DropColumnImpl.DropColumnImpl_Step001 step001 = new DropColumnImpl.DropColumnImpl_Step001(parameter);

        DropColumnImpl.DropColumnImpl_Step002 step002 = new DropColumnImpl.DropColumnImpl_Step002(parameter);

        DropColumnImpl.DropColumnImpl_Step003 step003 = new DropColumnImpl.DropColumnImpl_Step003(parameter);

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

    public static class Utility
    {
        public Utility(CreateDatabaseImpl parent, String sqlString)
        {

        }

        public static String getDatabaseName(Parameter parameter)
        {
            String sqlString = parameter.sqlstring;

            StringTokenizer tokenizer = new StringTokenizer(sqlString, " ");

            String token001 = tokenizer.nextToken();

            String token002 = tokenizer.nextToken();

            String token003 = tokenizer.nextToken();

            if(token003==null) return null;

            return token003;
        }
    }
}
