package structures.database;

import cases.UseImpl;
import constants.DatabaseConstants;
import parameter.Parameter;

import java.util.StringTokenizer;

public class DatabaseReference
{
    public String name;

    public String fileURL;

    public Parameter parameter;

    public DatabaseReference(Parameter parameter)
    {
        this.parameter = parameter;
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
            public Parameter parameter;

            public File(Parameter parameter)
            {
                this.parameter = parameter;
            }
        }

        public static class Name
        {
            public Parameter parameter;

            public Name(Parameter parameter)
            {
                this.parameter = parameter;
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

        public static java.io.File getdatabasefile(Parameter parameter)
        {
            return new java.io.File(DatabaseConstants.baseURL+"\\"+parameter.database_name +".sql");
        }
    }

}
