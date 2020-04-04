package parameter;

import cases.UseCase;
import components.database.Database;
import structures.table.Table;

public class Parameter
{
    public String sqlstring;

    public String tblname = "";

    public String dbname = "";

    public UseCase parent;

    public String url;

    public Database database;

    public Table table;

    public Parameter(UseCase parent, String sqlstring)
    {
        this.parent = parent;

        this.sqlstring = sqlstring;
    }
}