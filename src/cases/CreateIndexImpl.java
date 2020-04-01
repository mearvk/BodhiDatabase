package cases;

import constants.DatabaseConstants;
import parameter.Parameter;
import system.System;

import java.io.File;
import java.util.StringTokenizer;

public class CreateIndexImpl extends UseCase
{
    public CreateIndexImpl(String sqlString) throws Exception
    {
        System.pre("//continue");

        //

        Parameter parameter = new Parameter(this, sqlString);

        //

        CreateIndexImpl.CreateIndexImpl_Step001 step001 = new CreateIndexImpl.CreateIndexImpl_Step001(parameter);

        CreateIndexImpl.CreateIndexImpl_Step002 step002 = new CreateIndexImpl.CreateIndexImpl_Step002(parameter);

        CreateIndexImpl.CreateIndexImpl_Step003 step003 = new CreateIndexImpl.CreateIndexImpl_Step003(parameter);
    }

    public static class CreateIndexImpl_Step001
    {
        public CreateIndexImpl_Step001(Parameter parameter) throws Exception
        {
            System.touch("//database");
        }
    }

    public static class CreateIndexImpl_Step002
    {
        public CreateIndexImpl_Step002(Parameter parameter) throws Exception
        {
            //TODO JSON in RAM and output option
        }
    }

    public static class CreateIndexImpl_Step003
    {
        public CreateIndexImpl_Step003(Parameter parameter) throws Exception
        {
            System.touch("//database");
        }
    }

    public static class Utility
    {
        public static String getDatabaseFile(Parameter parameter)
        {
            return DatabaseConstants.baseURL +"\\"+ getDatabaseName(parameter) + ".sql";
        }

        public static String getDatabaseName(Parameter parameter)
        {
            var sqlstring = parameter.sqlstring;

            var tokenizer = new StringTokenizer(sqlstring, " ");

            var token001 = tokenizer.nextToken().toLowerCase();

            var token002 = tokenizer.nextToken().toLowerCase();

            var token003 = tokenizer.nextToken().toLowerCase();

            return token003;
        }

        public static String[] getExistingDatabaseNames(Parameter parameter)
        {
            var files = new File(DatabaseConstants.baseURL).listFiles();

            var names = new String[files.length];

            for(int i=0; i<files.length; i++)
            {
                StringTokenizer tokenizer = new StringTokenizer(files[i].getName(), ".");

                names[i] = tokenizer.nextToken();
            }

            return names;
        }
    }
}
