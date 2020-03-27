package cases;

import structures.database.handler.DatabaseHandler;
import constants.DatabaseConstants;
import file.DatabaseWriter;
import file.TableWriter;
import parameter.Parameter;
import structures.database.Database;
import system.System;

import java.util.StringTokenizer;

public class CreateTableImpl extends UseCase
{
    public CreateTableImpl.CreateTableImpl_Step001 step001;

    public CreateTableImpl.CreateTableImpl_Step002 step002;

    public CreateTableImpl.CreateTableImpl_Step003 step003;

    public Parameter parameter;

    public CreateTableImpl(String sqlstring)
    {
        System.Memory.reference.push("//impl/createtable", this);

        //

        this.parameter = new Parameter(this, sqlstring);

        //

        try
        {   this.step001 = new CreateTableImpl.CreateTableImpl_Step001(this.parameter);

            this.step002 = new CreateTableImpl.CreateTableImpl_Step002(this.parameter);

            this.step003 = new CreateTableImpl.CreateTableImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class CreateTableImpl_Step001
    {
        public CreateTableImpl_Step001(Parameter parameter) throws Exception
        {
            //TODO check out integrity before writer impl a lil
        }
    }

    public static class CreateTableImpl_Step002
    {
        public CreateTableImpl_Step002(Parameter parameter) throws Exception
        {
            DatabaseWriter writer = new DatabaseWriter(parameter);

            writer.write_table();
        }
    }

    public static class CreateTableImpl_Step003
    {
        public CreateTableImpl_Step003(Parameter parameter) throws Exception
        {
            //TODO quickly wash hands; integrity check the database then return 
        }
    }

    public static class Utility
    {
        public CreateTableImpl parent;

        public String sqlString;

        public Utility(CreateTableImpl parent, String sqlString)
        {
            this.parent = parent;

            this.sqlString = sqlString;
        }

        public static String getDatabaseUrl(Parameter parameter)
        {
            return DatabaseConstants.baseURL+"\\"+parameter.database_name +".sql";
        }

        public static String getDatabaseName(Parameter parameter)
        {
            return ((Database)System.Memory.reference.pull("//database")).name;
        }

        public static String getTableName(Parameter parameter)
        {
            String sqlString = parameter.sqlstring;

            StringTokenizer tokenizer = new StringTokenizer(sqlString, " ");

            String token001 = tokenizer.nextToken();

            String token002 = tokenizer.nextToken();

            String token003 = tokenizer.nextToken();

            return token003;
        }

    }
}


