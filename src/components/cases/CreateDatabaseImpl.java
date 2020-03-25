package components.cases;

import constants.Database;
import system.System;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class CreateDatabaseImpl
{
    public CreateDatabaseImpl_Step001 step001;

    public CreateDatabaseImpl_Step002 step002;

    public CreateDatabaseImpl_Step003 step003;

    public String dbasename;

    public Parameter parameter;

    public CreateDatabaseImpl(String sqlString)
    {
        System.Memory.reference.push("//createdatabaseimpl", this);

        //

        this.parameter = new Parameter(this, sqlString);

        //

        try
        {   this.step001 = new CreateDatabaseImpl_Step001(this.parameter);

            this.step002 = new CreateDatabaseImpl_Step002(this.parameter);

            this.step003 = new CreateDatabaseImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class CreateDatabaseImpl_Step001
    {
        public CreateDatabaseImpl_Step001(Parameter parameter) throws Exception
        {
            parameter.databasename_uppercase = CreateDatabaseImplUtility.getDatabaseName(parameter.sqlString).toUpperCase();

            parameter.databasename_lowercase = CreateDatabaseImplUtility.getDatabaseName(parameter.sqlString).toLowerCase();
        }
    }

    public static class CreateDatabaseImpl_Step002
    {
        public CreateDatabaseImpl_Step002(Parameter parameter) throws Exception
        {
            File file;

            BufferedWriter writer = new BufferedWriter(new FileWriter(file = new File(Database.baseURL+"\\"+parameter.databasename_lowercase+".sql")));

            if(file.exists())
            {

            }
            else
            {
                writer.write("employees.sql");

                writer.flush();

                writer.close();

                writer = null;
            }
        }
    }

    public static class CreateDatabaseImpl_Step003
    {
        public CreateDatabaseImpl_Step003(Parameter parameter) throws Exception
        {
            //
        }
    }

    public static class CreateDatabaseImplUtility
    {
        public CreateDatabaseImplUtility(CreateDatabaseImpl parent, String sqlString)
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

        public CreateDatabaseImpl parent;

        File file;

        public Parameter(CreateDatabaseImpl parent, String sqlString)
        {
            this.parent = parent;

            this.sqlString = sqlString;
        }
    }
}

