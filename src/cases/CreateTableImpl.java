package cases;

import components.database.Database;
import constants.DatabaseConstants;
import file.TableReader;
import file.TableWriter;
import parameter.Parameter;
import structures.table.Table;
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
            parameter.databasename = Utility.getDatabaseName(parameter).toLowerCase();

            parameter.tablename = Utility.getTableName(parameter).toLowerCase();

            parameter.databaseurl = DatabaseConstants.baseURL+"\\"+parameter.databasename+".sql";
        }
    }

    public static class CreateTableImpl_Step002
    {
        public CreateTableImpl_Step002(Parameter parameter) throws Exception
        {
            TableWriter writer = new TableWriter(new Table(parameter));

            writer.write();
        }
    }

    public static class CreateTableImpl_Step003
    {
        public CreateTableImpl_Step003(Parameter parameter) throws Exception
        {
            TableReader reader = new TableReader(new Table(parameter));

            reader.read();
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

        public static String getDatabaseName(Parameter parameter)
        {
            Database database = (Database)System.Memory.reference.pull("//database");

            return database.name;
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


