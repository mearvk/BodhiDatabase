package cases;

import parameter.Parameter;
import system.System;

import java.util.StringTokenizer;

public class InsertIntoTableImpl extends UseCase
{
    public InsertIntoTableImpl(String sql_string) throws Exception
    {
        System.pre("//continue");

        //

        Parameter parameter = new Parameter(this, sql_string, InsertIntoTableImpl.class);

        //

        InsertIntoTableImpl.InsertIntoImpl_Step001 step001 = new InsertIntoTableImpl.InsertIntoImpl_Step001(parameter);

        InsertIntoTableImpl.InsertIntoImpl_Step002 step002 = new InsertIntoTableImpl.InsertIntoImpl_Step002(parameter);

        InsertIntoTableImpl.InsertIntoImpl_Step003 step003 = new InsertIntoTableImpl.InsertIntoImpl_Step003(parameter);
    }

    public static class InsertIntoImpl_Step001
    {
        public InsertIntoImpl_Step001(Parameter parameter) throws Exception
        {
            PreconditionCheck check = new PreconditionCheck(parameter);
        }
    }

    public static class InsertIntoImpl_Step002
    {
        public InsertIntoImpl_Step002(Parameter parameter) throws Exception
        {
            TaskRunner runner = new TaskRunner(parameter);
        }
    }

    public static class InsertIntoImpl_Step003
    {
        public InsertIntoImpl_Step003(Parameter parameter) throws Exception
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

    public static class Utility
    {
        public Utility(CreateDatabaseImpl parent, String sqlString)
        {

        }

        public static String getDatabaseName(Parameter parameter)
        {
            String sqlString = parameter.sql_string;

            StringTokenizer tokenizer = new StringTokenizer(sqlString, " ");

            String token001 = tokenizer.nextToken();

            String token002 = tokenizer.nextToken();

            String token003 = tokenizer.nextToken();

            if(token003==null) return null;

            return token003;
        }
    }
}
