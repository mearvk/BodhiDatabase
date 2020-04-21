package structures.database;

import cases.CreateDatabaseImpl;
import cases.CreateTableImpl;

import cases.UseDatabaseImpl;
import parameter.Parameter;
import structures.Structure;
import structures.table.Table;

import java.util.HashMap;

public class Database extends Structure
{
    public static Database reference;

    //

    public String exists;

    public String name;

    public String uri;

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
        if(context.isAssignableFrom(UseDatabaseImpl.PreconditionCheck.class))
        {
            Database.reference = this;

            this.exists = UseDatabaseImpl.Utility.getDatabaseExists(parameter);

            this.name = UseDatabaseImpl.Utility.getDatabaseName(parameter);

            this.uri = UseDatabaseImpl.Utility.getDatabaseUrl(parameter);

            this.parameter = parameter;

            this.context = context;
        }
        if(context.isAssignableFrom(CreateTableImpl.PreconditionCheck.class))
        {
            Database.reference = this;

            this.exists = CreateTableImpl.Utility.getDatabaseExists(parameter);

            this.name = CreateTableImpl.Utility.getDatabaseName(parameter);

            this.uri = CreateTableImpl.Utility.getDatabaseUrl(parameter);

            this.parameter = parameter;

            this.context = context;
        }
        if(context.isAssignableFrom(CreateTableImpl.TaskRunner.class))
        {
            Database.reference = this;

            this.exists = CreateTableImpl.Utility.getDatabaseExists(parameter);

            this.name = CreateTableImpl.Utility.getDatabaseName(parameter);

            this.uri = CreateTableImpl.Utility.getDatabaseUrl(parameter);

            this.parameter = parameter;

            this.context = context;
        }
        else if(context.isAssignableFrom(CreateDatabaseImpl.PreconditionCheck.class))
        {
            Database.reference = this;

            this.exists = CreateDatabaseImpl.Utility.getDatabaseExists(parameter);

            this.name = CreateDatabaseImpl.Utility.getDatabaseName(parameter);

            this.uri = CreateDatabaseImpl.Utility.getDatabaseUrl(parameter);

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
}

