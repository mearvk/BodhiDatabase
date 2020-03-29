package structures.database;

import cases.UseImpl;
import constants.DatabaseConstants;
import parameter.Parameter;

import java.io.File;
import java.util.StringTokenizer;

public class DatabaseReference
{
    public Parameter parameter;

    public Reference reference;

    public Reference.File file;

    public Reference.Name name;

    public DatabaseReference(Parameter parameter)
    {
        this.parameter = parameter;

        this.reference = new Reference(parameter);

        this.name = new Reference.Name(parameter);

        this.file = new Reference.File(parameter);
    }

    public static class Reference
    {
        public Parameter parameter;

        public Reference(Parameter parameter)
        {
            this.parameter = parameter;
        }

        public static class File
        {
            public java.io.File file;

            public Parameter parameter;

            public File(Parameter parameter)
            {
                this.parameter = parameter;

                this.file = parameter.database_file = Utility.getdatabasefile(parameter);

                system.System.push("//database/file", this.file);
            }
        }

        public static class Name
        {
            public String name;

            public Parameter parameter;

            public Name(Parameter parameter)
            {
                this.parameter = parameter;

                this.parameter.database_name = this.name = Utility.getdatabasename(parameter);

                system.System.push("//database/name", this.name);
            }
        }
    }

    private static class Utility
    {
        UseImpl parent;

        public String sqlstring;

        public Utility(UseImpl parent, String sqlstring)
        {
            this.parent = parent;

            this.sqlstring = sqlstring;
        }

        private static String getdatabasename(Parameter parameter)
        {
            String sqlstring = parameter.sqlstring;

            StringTokenizer tokenizer = new StringTokenizer(sqlstring, " ");

            String token001 = tokenizer.nextToken();

            String token002 = tokenizer.nextToken();

            return token002.trim().toLowerCase();
        }

        public static File getdatabasefile(Parameter parameter)
        {
            return new java.io.File(DatabaseConstants.baseURL+"\\"+parameter.database_name +".sql");
        }
    }

}
