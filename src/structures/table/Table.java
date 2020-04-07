package structures.table;

import system.System;
import cases.CreateTableImpl;
import parameter.Parameter;

import java.util.*;

public class Table
{
    public Parameter parameter;

    public String name;

    public String url;

    public Class<?> context;

    public String[] column_names;

    public String[] column_types;

    public String[] value_names;

    public String[] value_values;

    public HashMap<String, String> map = null;

    //

    public Table(Parameter parameter, Class<?> context) throws Exception
    {
        this.parameter = parameter;

        this.context = context;

        this.name = parameter.table_name;

        this.url = parameter.url;

        //

        Parser parser = new Parser(this,context);
    }

    public static class Parser
    {
        public Table table;

        public Parser(Table table, Class<?> context)  throws Exception
        {
            this.table = table;

            //

            new Parser_Step001(table, context);

            new Parser_Step002(table, context);

            new Parser_Step003(table, context);
        }

        public static class Parser_Step001
        {
            public Table table;

            public Parser_Step001(Table table, Class<?> context) throws Exception
            {
                if(context.isAssignableFrom(CreateTableImpl.PreconditionCheck.class))
                {
                    this.table = table;

                    //

                    int start = table.parameter.sql_string.indexOf("(")+1;

                    int end = table.parameter.sql_string.lastIndexOf(")");

                    String store = table.parameter.sql_string.substring(start, end);

                    //

                    System.storage("//substring", store);
                }
            }
        }

        public static class Parser_Step002
        {
            public Table table;

            public Parser_Step002(Table table, Class<?> context) throws Exception
            {
                java.lang.System.out.println("Context was/is "+context);

                this.table = table;

                //

                String string = (String) System.storage("//substring");

                //

                StringTokenizer tokenizer01 = new StringTokenizer(string, ",");

                StringTokenizer tokenizer02;

                String line = "";

                HashMap<String, String> tokens_map = new HashMap<>();


                for(;tokenizer01.hasMoreTokens();)
                {
                    String [] tokens = tokenizer01.nextToken().trim().split(" ");

                    tokens_map.put(tokens[0], tokens[1]);
                }

                //

                System.storage("//map", tokens_map);
            }
        }

        public static class Parser_Step003
        {
            public Table table;

            public Parser_Step003(Table table, Class<?> context) throws Exception
            {
                this.table = table;

                //

                HashMap<String, String> map = (HashMap<String, String>)System.storage("//map");

                //

                Set<Map.Entry<String,String>> entryset = map.entrySet();

                //

                this.table.column_names = new String[entryset.size()];

                this.table.column_types = new String[entryset.size()];

                //

                int i=0;

                for( Map.Entry<String, String> entry : entryset)
                {

                    this.table.column_names[i] = (String) entry.getKey().toLowerCase().trim();

                    this.table.column_types[i] = (String) entry.getValue().toLowerCase().trim();

                    i++;
                }
            }
        }
    }
}

