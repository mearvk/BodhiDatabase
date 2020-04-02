package components.database;

import cases.CreateTableImpl;
import cases.UseDatabaseImpl;
import components.Component;
import parameter.Parameter;
import system.System;

import java.util.HashMap;

public class Database extends Component
{
    public Parameter parameter;

    public String name;

    public String url;

    public static Database reference;

    public HashMap<String, Table> tables = new HashMap<>();

    public Database() throws Exception
    {
        Database.reference = this;
    }

    public Database(String sqlstring) throws Exception
    {

    }

    public Database(Parameter parameter, Class<?> klass) throws Exception
    {
        if(klass.isAssignableFrom(UseDatabaseImpl.PreconditionCheck.class))
        {
            Database.reference = this;

            Database.reference.name = CreateTableImpl.Utility.getDatabaseName(parameter);

            Database.reference.url = CreateTableImpl.Utility.getDatabaseUrl(parameter);
        }

        if(klass.isAssignableFrom(CreateTableImpl.TaskRunner.class))
        {
            Database.reference = this;

            Database.reference.name = CreateTableImpl.Utility.getDatabaseName(parameter);

            Database.reference.url = CreateTableImpl.Utility.getDatabaseUrl(parameter);
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
