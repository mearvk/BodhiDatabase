package cases;

import constants.DatabaseConstants;
import parameter.Parameter;
import system.System;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class CreateDatabaseImpl extends UseCase
{
    public CreateDatabaseImpl_Step001 step001;

    public CreateDatabaseImpl_Step002 step002;

    public CreateDatabaseImpl_Step003 step003;

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
            parameter.database_name = Utility.getDatabaseName(parameter).toLowerCase();
        }
    }

    public static class CreateDatabaseImpl_Step002
    {
        public CreateDatabaseImpl_Step002(Parameter parameter) throws Exception
        {
            File file;

            BufferedWriter writer = new BufferedWriter(new FileWriter(file = new File(DatabaseConstants.baseURL+"\\"+parameter.database_name +".sql")));

            if(file.exists()) throw new Exception();

            else
             {
                writer.write("File Name >> " + parameter.database_name + ".sql");

                writer.newLine();

                writer.write("Database Name >> " + parameter.database_name);

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

