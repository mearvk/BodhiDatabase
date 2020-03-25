package components.cases;

import constants.Database;
import system.System;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class UseImpl
{
    public UseImpl.UseImpl_Step001 step001;

    public UseImpl.UseImpl_Step002 step002;

    public UseImpl.UseImpl_Step003 step003;

    public UseImpl.Parameter parameter;

    public UseImpl(String sqlString)
    {
        System.Memory.reference.push("//useimpl", this);

        //

        this.parameter = new UseImpl.Parameter(this, sqlString);

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
        public UseImpl_Step001(UseImpl.Parameter parameter) throws Exception
        {
            System.Database.database = new System.Database(parameter.databasename_lowercase);
        }
    }

    public static class UseImpl_Step002
    {
        public UseImpl_Step002(UseImpl.Parameter parameter) throws Exception
        {
            File file;

            BufferedWriter writer = new BufferedWriter(new FileWriter(file = new File(Database.baseURL+"\\"+parameter.databasename_lowercase+".sql")));

            if(file.exists()) throw new Exception();

            else
            {
                writer.write("File Name >> " + parameter.databasename_lowercase + ".sql");

                writer.newLine();

                writer.write("Database Name >> " + parameter.databasename_lowercase);

                writer.flush();

                writer.close();

                writer = null;
            }
        }
    }

    public static class UseImpl_Step003
    {
        public UseImpl_Step003(UseImpl.Parameter parameter) throws Exception
        {
            //
        }
    }

    public static class UseImplUtility
    {
        public UseImplUtility(UseImpl parent, String sqlString)
        {

        }

        public static String getDatabaseName(String sqlString)
        {
            StringTokenizer tokenizer = new StringTokenizer(sqlString, " ");

            String token001 = tokenizer.nextToken();

            String token002 = tokenizer.nextToken();

            String token003 = tokenizer.nextToken();

            if(token003==null) return null;

            return token003;
        }
    }

    public static class Parameter
    {
        public String sqlString;

        public String databasename_uppercase = "";

        public String databasename_lowercase = "";

        public UseImpl parent;

        File file;

        public Parameter(UseImpl parent, String sqlString)
        {
            this.parent = parent;

            this.sqlString = sqlString;
        }
    }
}
