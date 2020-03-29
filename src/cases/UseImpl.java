package cases;

import components.database.DatabaseComponent;
import constants.DatabaseConstants;
import context.UseImplContext;
import parameter.Parameter;
import system.System;

import java.io.File;
import java.util.StringTokenizer;

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
            parameter.name = Utility.getDatabaseName(parameter);

            parameter.file = Utility.getDatabaseFile(parameter);
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.touch("//database", "//database/properties/name", "//database/properties/file");

            //

            DatabaseComponent.Reference database = new DatabaseComponent.Reference();

            System.push("//database", database);

            System.push("//database/properties/name", parameter.name);

            System.push("//database/properties/file", parameter.file);

            java.lang.System.out.println("Database <" + parameter.name + "> selected.");
        }
    }

    public static class PostConditionRunner
    {
        public PostConditionRunner(Parameter parameter) throws Exception
        {
            System.set("//parameter/name", parameter, new UseImplContext());

            System.set("//parameter/file", parameter, new UseImplContext());

            parameter.name = Utility.getDatabaseName(parameter);

            parameter.file = Utility.getDatabaseFile(parameter);
        }
    }

    public static class Utility
    {
        public static File getDatabaseFile(Parameter parameter)
        {
            return new File(DatabaseConstants.baseURL +"\\"+ parameter.name + ".sql");
        }

        public static String getDatabaseName(Parameter parameter)
        {
            String sqlString = parameter.sqlstring;

            StringTokenizer tokenizer = new StringTokenizer(sqlString, " ");

            String token001 = tokenizer.nextToken();

            String token002 = tokenizer.nextToken();

            return token002.toLowerCase();
        }
    }
}
