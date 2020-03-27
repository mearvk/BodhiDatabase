package parameter;

import cases.UseCase;

import java.io.File;

public class Parameter
{
    public String sqlstring;

    public String tablename = "";

    public String databasename = "";

    public String databaseurl = "";

    public UseCase parent;

    public File file;

    public Parameter(UseCase parent, String sqlString)
    {
        this.parent = parent;

        this.sqlstring = sqlString;
    }
}