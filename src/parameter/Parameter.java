package parameter;

import cases.UseCase;

public class Parameter
{
    public String sqlstring;

    public String table_name = "";

    public String name = "";

    public String database_url = "";

    public UseCase parent;

    public String file;

    public Parameter(UseCase parent, String sqlString)
    {
        this.parent = parent;

        this.sqlstring = sqlString;
    }
}