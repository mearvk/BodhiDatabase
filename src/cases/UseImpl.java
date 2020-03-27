package cases;

import constants.DatabaseConstants;
import parameter.Parameter;
import structures.database.Database;
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

    public static class utility
    {
        UseImpl parent;

        public utility(UseImpl parent, String sqlString)
        {
            this.parent = parent;
        }

        public static String getdatabasename(Parameter parameter)
        {
            String sqlstring = parameter.sqlstring;

            StringTokenizer tokenizer = new StringTokenizer(sqlstring, " ");

            String token001 = tokenizer.nextToken();

            String token002 = tokenizer.nextToken();

            return token002.trim().toLowerCase();
        }

        public static File getdatabasefile(Parameter parameter)
        {
            return new File(DatabaseConstants.baseURL+"\\"+parameter.database_name +".sql");
        }
    }

    public static class PreConditionRunner
    {
        public PreConditionRunner(Parameter parameter) throws Exception
        {
            System.push("//database", parameter.database = new Database(parameter));

            System.push("//database/name", parameter.database_name = utility.getdatabasename(parameter));

            System.push("//database/file", parameter.database_file = utility.getdatabasefile(parameter));
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.wheat("//database");

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
