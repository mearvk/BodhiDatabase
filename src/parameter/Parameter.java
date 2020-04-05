package parameter;

import cases.CreateTableImpl;
import cases.UseCase;
import components.database.Database;
import structures.table.Table;

public class Parameter
{
    public String sql_string;

    public String table_name = "";

    public String database_name = "";

    public UseCase parent;

    public String url;

    public Database database;

    public Table table;

    public Parameter(UseCase parent, String sql_string, Class<?> context)
    {
        if(context.isAssignableFrom(CreateTableImpl.class))
        {
            this.parent = parent;

            this.sql_string = sql_string;

            this.table_name = CreateTableImpl.Utility.getTableName(this);

            this.database_name = CreateTableImpl.Utility.getDatabaseName(this);

            this.url = CreateTableImpl.Utility.getDatabaseUrl(this);
        }
        else
        {
            //TODO write all the cases for Utility
        }

        this.parent = parent;

        this.sql_string = sql_string;
    }
}