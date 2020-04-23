package structures.database;

import cases.CreateDatabaseImpl;
import cases.CreateTableImpl;

import cases.UseDatabaseImpl;
import parameter.Parameter;
import structures.Structure;
import structures.io.DatabaseWrit;
import structures.table.Table;

import java.io.File;
import java.util.HashMap;

public class Database extends Structure
{
    public static Database reference;

    //

    public String selected;

    public String exists;

    public String name;

    public String uri;

    public DatabaseWrit writ;

    public Parameter parameter;

    public Class<?> context;

    public File file;

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
        else if(context.isAssignableFrom(UseDatabaseImpl.TaskRunner.class))
        {
            Database.reference = this;

            this.exists = UseDatabaseImpl.Utility.getDatabaseExists(parameter);

            this.name = UseDatabaseImpl.Utility.getDatabaseName(parameter);

            this.uri = UseDatabaseImpl.Utility.getDatabaseUrl(parameter);

            this.parameter = parameter;

            this.context = context;

            this.selected = "true";

            System.out.println("URL: "+UseDatabaseImpl.Utility.getDatabaseUrl(parameter));

            //this.file = new File(UseDatabaseImpl.Utility.getDatabaseUrl(parameter)+"\\"+this.name);
        }
        else if(context.isAssignableFrom(CreateTableImpl.PreconditionCheck.class))
        {
            Database.reference = this;

            this.exists = CreateTableImpl.Utility.getDatabaseExists(parameter);

            this.name = CreateTableImpl.Utility.getDatabaseName(parameter);

            this.uri = CreateTableImpl.Utility.getDatabaseUrl(parameter);

            this.parameter = parameter;

            this.context = context;
        }
        else if(context.isAssignableFrom(CreateTableImpl.TaskRunner.class))
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

        else if(context.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
        {
            Database.reference = this;

            this.exists = CreateDatabaseImpl.Utility.getDatabaseExists(parameter);

            this.name = CreateDatabaseImpl.Utility.getDatabaseName(parameter);

            this.uri = CreateDatabaseImpl.Utility.getDatabaseUrl(parameter);

            this.parameter = parameter;

            this.context = context;

            this.writ = new DatabaseWrit(this); //implement me
        }

        else if(context.isAssignableFrom(CreateDatabaseImpl.PostconditionCheck.class))
        {
            /**

            System.touch("//database", "@self", parameter, context);

            System.touch("//database", "@exists", parameter, context);

            System.touch("//database", "@exists", parameter, context);

             */
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

