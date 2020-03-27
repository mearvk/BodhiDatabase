package cases;

import components.database.Database;
import constants.DatabaseConstants;
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
        System.Memory.reference.push("//useimpl", this);

        //

        this.parameter = new Parameter(this, sqlString);

        //

        try
        {   this.step001 = new UseImpl.UseImpl_Step001(this.parameter);

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
            parameter.databasename = Utility.getDatabaseName(parameter.sqlstring).toLowerCase();

            parameter.databasename = Utility.getDatabaseName(parameter.sqlstring).toUpperCase();
        }
    }

    public static class UseImpl_Step002
    {
        public UseImpl_Step002(Parameter parameter) throws Exception
        {
            File file = new File(DatabaseConstants.baseURL+"\\"+parameter.databasename+".sql");

            if(!file.exists())
            {
                java.lang.System.out.println("No such database <"+parameter.databasename+">.");

                throw new Exception("<No such database>");
            }

            System.Memory.reference.push("//database", new Database(parameter));

            java.lang.System.out.println("Database <"+parameter.databasename+"> selected.");
        }
    }

    public static class UseImpl_Step003
    {
        public UseImpl_Step003(Parameter parameter) throws Exception
        {
            return;
        }
    }

    public static class Utility
    {
        UseImpl parent;

        public Utility(UseImpl parent, String sqlString)
        {

        }

        public static String getDatabaseName(String sqlString)
        {
            StringTokenizer tokenizer = new StringTokenizer(sqlString, " ");

            String token001 = tokenizer.nextToken();

            String token002 = tokenizer.nextToken();

            return token002;
        }
    }
}
