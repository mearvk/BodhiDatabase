package cases;

import components.database.Database;
import constants.DatabaseConstants;
import file.DatabaseReader;
import file.DatabaseWriter;
import system.System;

import java.io.File;
import java.util.StringTokenizer;

public class CreateTableImpl extends Case
{
    public CreateTableImpl.CreateTableImpl_Step001 step001;

    public CreateTableImpl.CreateTableImpl_Step002 step002;

    public CreateTableImpl.CreateTableImpl_Step003 step003;

    public CreateTableImpl.Parameter parameter;

    public CreateTableImpl(String sqlString)
    {
        System.Memory.reference.push("//createtableimpl", this);

        //

        this.parameter = new CreateTableImpl.Parameter(this, sqlString);

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
        public CreateTableImpl_Step001(CreateTableImpl.Parameter parameter) throws Exception
        {
            parameter.databasename = CreateTableImpl.CreateTableImplUtility.getDatabaseName().toLowerCase();

            parameter.tablename = CreateTableImpl.CreateTableImplUtility.getTableName(parameter.sqlString).toLowerCase();

            parameter.databaseurl = DatabaseConstants.baseURL+"\\"+parameter.databasename+".sql";
        }
    }

    public static class CreateTableImpl_Step002
    {
        public CreateTableImpl_Step002(Parameter parameter) throws Exception
        {
            DatabaseReader reader = new DatabaseReader(new Database(parameter.databasename, parameter.file));

            DatabaseWriter writer = new DatabaseWriter(new Database(parameter.databasename, parameter.file));

            if(reader.databaseExists(parameter.databasename))
            {
                if(writer.tableExists(parameter.tablename))
                {

                }
                else
                {
                    writer.createTable(parameter.tablename);
                }
            }

            java.lang.System.out.println("Table <"+parameter.databasename+"> created.");
        }
    }

    public static class CreateTableImpl_Step003
    {
        public CreateTableImpl_Step003(CreateTableImpl.Parameter parameter) throws Exception
        {
            //step 3
        }
    }

    public static class Parameter
    {
        public String sqlString;

        public String tablename = "";

        public String databasename = "";

        public String databaseurl = "";

        public CreateTableImpl parent;

        public File file;

        public Parameter(CreateTableImpl parent, String sqlString)
        {
            this.parent = parent;

            this.sqlString = sqlString;
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


