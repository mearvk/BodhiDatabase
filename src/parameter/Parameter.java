package parameter;

import cases.Case;
import cases.CreateTableImpl;

import java.io.File;

public class Parameter
{
    public String sqlstring;

    public String tablename = "";

    public String databasename = "";

    public String databaseurl = "";

    public Case parent;

    public File file;

    public Parameter(Case parent, String sqlString)
    {
        this.parent = parent;

        this.sqlstring = sqlString;
    }
}