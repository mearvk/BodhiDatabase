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

            //

            String databasename = parameter.databasename;

            String tablename = parameter.tablename;

            String sqlstring = parameter.sqlstring;

            //

            if(reader.database_exists(databasename))
            {
                if(reader.table_not_exists(tablename))
                {
                    writer.create_table(sqlstring);
                }
            }
        }
    }

    public static class CreateTableImpl_Step003
    {
        public CreateTableImpl_Step003(Parameter parameter) throws Exception
        {
            DatabaseReader reader = new DatabaseReader(new Database(parameter));

            //

            Boolean result1;

            Boolean result2;

            //

            result1 = reader.verify_database(parameter.sqlstring);

            result2 = reader.verify_table(parameter.sqlstring);

            if(result1 && result2) return;

            //TODO build output to a error/exception file
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


