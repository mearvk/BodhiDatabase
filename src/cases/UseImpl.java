package cases;

import parameter.Parameter;
import structures.database.DatabaseReference;
import system.System;

public class UseImpl extends UseCase
{
    public UseImpl.UseImpl_Step001 step001;

    public UseImpl.UseImpl_Step002 step002;

    public UseImpl.UseImpl_Step003 step003;

    public Parameter parameter;

    public UseImpl(String sqlString)
    {
        System.Memory.reference.push("//impl/use", this);

        //

        this.parameter = new Parameter(this, sqlString);

        //

        try
        {
            this.step001 = new UseImpl.UseImpl_Step001(this.parameter);

            this.step002 = new UseImpl.UseImpl_Step002(this.parameter);

            this.step003 = new UseImpl.UseImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class UseImpl_Step001
    {
        public UseImpl_Step001(Parameter parameter) throws Exception
        {
            System.Memory.reference.push("//step001", new PreConditionRunner(parameter));
        }
    }

    public static class UseImpl_Step002
    {
        public UseImpl_Step002(Parameter parameter) throws Exception
        {
            System.Memory.reference.push("//step002", new TaskRunner(parameter));
        }
    }

    public static class UseImpl_Step003
    {
        public UseImpl_Step003(Parameter parameter) throws Exception
        {
            System.Memory.reference.push("//step003", new PostConditionRunner(parameter));
        }
    }

    public static class PreConditionRunner
    {
        public PreConditionRunner(Parameter parameter) throws Exception
        {
            System.push("//database", new DatabaseReference.Reference(parameter));

            System.push("//database/name", new DatabaseReference.Reference.Name(parameter));

            System.push("//database/file", new DatabaseReference.Reference.File(parameter));
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.touch("//database");

            System.touch("//database/name");

            System.touch("//database/file");

            //

            DatabaseReference.Reference.Name name = (DatabaseReference.Reference.Name)System.pull("//database/name");

            System.non_null(name.name,"<Name was not set>");

            java.lang.System.out.println("Database <" + parameter.database_name + "> selected.");
        }
    }

    public static class PostConditionRunner
    {
        public PostConditionRunner(Parameter parameter) throws Exception
        {

        }
    }
}
