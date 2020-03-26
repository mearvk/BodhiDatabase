package cases;

import components.database.Database;
import constants.DatabaseConstants;
import file.DatabaseReader;
import file.DatabaseWriter;
import parameter.Parameter;
import system.System;

import java.util.StringTokenizer;

public class CreateTableImpl extends Case
{
    public CreateTableImpl.CreateTableImpl_Step001 step001;

    public CreateTableImpl.CreateTableImpl_Step002 step002;

    public CreateTableImpl.CreateTableImpl_Step003 step003;

    public Parameter parameter;

    public CreateTableImpl(String sqlstring)
    {
        System.Memory.reference.push("//createtableimpl", this);

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
            parameter.databasename = CreateTableImpl.CreateTableImplUtility.getDatabaseName().toLowerCase();

            parameter.tablename = CreateTableImpl.CreateTableImplUtility.getTableName(parameter.sqlstring).toLowerCase();

            parameter.databaseurl = DatabaseConstants.baseURL+"\\"+parameter.databasename+".sql";
        }
    }

    public static class CreateTableImpl_Step002
    {
        public CreateTableImpl_Step002(Parameter parameter) throws Exception
        {
            DatabaseReader reader = new DatabaseReader(new Database(parameter));

            DatabaseWriter writer = new DatabaseWriter(new Database(parameter));

            if(reader.database_exists(parameter.databasename))
            {
                if(writer.table_exists(parameter.tablename))
                {
                    throw new Exception("Table <"+parameter.tablename+"> already exists.");
                }
                else
                {
                    writer.create_table(parameter.sqlstring);

                    java.lang.System.out.println("Table <"+parameter.databasename+"> created.");
                }
            }
        }
    }

    public static class CreateTableImpl_Step003
    {
        public CreateTableImpl_Step003(Parameter parameter) throws Exception
        {
            DatabaseReader reader = new DatabaseReader(new Database(parameter));

            reader.verifydatabase(parameter.sqlstring);

            reader.verify_table(parameter.sqlstring);
        }
    }

    public static class CreateTableImplUtility
    {
        public CreateTableImpl parent;

        public String sqlString;

        public CreateTableImplUtility(CreateTableImpl parent, String sqlString)
        {
            this.parent = parent;

            this.sqlString = sqlString;
        }

        public static String getDatabaseName()
        {
            Database database = (Database)System.Memory.reference.pull("//database");

            return database.name;
        }

        public static String getTableName(String sqlString)
        {
            StringTokenizer tokenizer = new StringTokenizer(sqlString, " ");

            String token001 = tokenizer.nextToken();

            String token002 = tokenizer.nextToken();

            String token003 = tokenizer.nextToken();

            return token003;
        }

    }
}


