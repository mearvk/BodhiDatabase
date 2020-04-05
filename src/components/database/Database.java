package components.database;

import cases.CreateDatabaseImpl;
import cases.CreateTableImpl;
import cases.UseDatabaseImpl;
import components.Component;
import parameter.Parameter;
import system.System;

import javax.xml.crypto.Data;
import java.util.HashMap;

public class Database extends Component
{
    public static Database reference;

    //

    public String exists;

    public String name;

    public String url;

    public Parameter parameter;

    public Class<?> context;

    //

    public HashMap<String, Table> tables = new HashMap<>();

    public Database() throws Exception
    {
        Database.reference = this;
    }

    public Database(Parameter parameter, Class<?> context) throws Exception
    {
        if(context.isAssignableFrom(CreateTableImpl.PreconditionCheck.class))
        {
            Database.reference = this;

            this.exists = CreateTableImpl.Utility.getDatabaseExists(parameter);

            this.name = CreateTableImpl.Utility.getDatabaseName(parameter);

            this.url = CreateTableImpl.Utility.getDatabaseUrl(parameter);

            this.parameter = parameter;

            this.context = context;
        }
        else if(context.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
        {
            Database.reference = this;

            this.exists = CreateDatabaseImpl.Utility.getDatabaseExists(parameter);

            this.name = CreateDatabaseImpl.Utility.getDatabaseName(parameter);

            this.url = CreateDatabaseImpl.Utility.getDatabaseUrl(parameter);

            this.parameter = parameter;

            this.context = context;
        }
    }

    public static class Properties
    {
        public String name;

        public String file;
    }

    public static class Reference
    {

    }

    public class Table
    {
        public String name;

        public String url;

        public Table(Parameter parameter, Class<?> klass) throws Exception
        {
            if(klass.isAssignableFrom(CreateTableImpl.TaskRunner.class))
            {
                System.touch("//database");

                System.touch("//database{name}");

                String name = this.name = CreateTableImpl.Utility.getTableName(parameter);

                String url = this.url = CreateTableImpl.Utility.getDatabaseUrl(parameter);
            }
        }
    }
}
