package parameter;

import cases.UseCase;
import components.database.Database;
import structures.table.Table;

public class Parameter
{
    public String sqlstring;

    public String table_name = "";

    public String name = "";

    public String database_url = "";

    public UseCase parent;

    public String file;

    public Database database;

    public Table table;

    public Parameter(UseCase parent, String sqlString)
    {
        this.parent = parent;

        this.sqlstring = sqlString;
    }
}