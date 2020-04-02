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
        if(context.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
        {
            Database.reference = this;

            Database.reference.exists = CreateDatabaseImpl.Utility.getDatabaseExists(parameter);

            Database.reference.name = CreateDatabaseImpl.Utility.getDatabaseName(parameter);

            Database.reference.url = CreateDatabaseImpl.Utility.getDatabaseUrl(parameter);

            Database.reference.parameter = parameter;

            Database.reference.context = context;
        }

        if(context.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
        {
            Database.reference = this;

            //Database.reference.exists = CreateDatabaseImpl.Utility.getDatabaseExists(parameter);

            Database.reference.name = CreateDatabaseImpl.Utility.getDatabaseName(parameter);

            Database.reference.url = CreateDatabaseImpl.Utility.getDatabaseUrl(parameter);

            Database.reference.parameter = parameter;

            Database.reference.context = context;
        }

        if(context.isAssignableFrom(UseDatabaseImpl.PreconditionCheck.class))
        {
            Database.reference = this;

            //Database.reference.exists = CreateDatabaseImpl.Utility.getDatabaseExists(parameter);

            Database.reference.name = UseDatabaseImpl.Utility.getDatabaseName(parameter);

            Database.reference.url = UseDatabaseImpl.Utility.getDatabaseUrl(parameter);

            Database.reference.parameter = parameter;

            Database.reference.context = context;
        }

        if(context.isAssignableFrom(CreateTableImpl.TaskRunner.class))
        {
            Database.reference = this;

            Database.reference.name = CreateTableImpl.Utility.getDatabaseName(parameter);

            Database.reference.url = CreateTableImpl.Utility.getDatabaseUrl(parameter);

            Database.reference.parameter = parameter;

            Database.reference.context = context;
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

    public static class Table
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
