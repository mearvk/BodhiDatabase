package io;

import components.persistence.Persistence;
import constants.DatabaseConstants;
import exceptions.ExceptionQueue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.*;
import parameter.Parameter;
import structures.database.Database;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;

import java.util.HashMap;

public class Writer
{
    public static Writer reference;

    public System system = new System();

    public Writer()
    {
        Writer.reference = this;
    }

    public Object writeXML(final String bodhi, final structures.database.Database database, final structures.table.Table table, final Parameter parameter, Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();

        persistence.writer.writeXML(bodhi, database, table, parameter, context);

        return persistence = null;
    }

    public Object writeXML(final String bodhi, final structures.database.Database database, final Parameter parameter, Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();

        persistence.writer.writeXML(bodhi, database, parameter, context);

        return persistence = null;
    }

    public Object checkXML(final String bodhi, final structures.database.Database database, final Parameter parameter, final Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();

        persistence.writer.checkXML(bodhi, database, this, parameter, context);

        return persistence = null;
    }

    //

    public void precheck(final String bodhi, final structures.database.Database database, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.runner(bodhi,"precheck", database, DatabaseWriter.Precheck.class);
    }

    public void runner(final String bodhi, final structures.database.Database database, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.runner(bodhi,"runner", database, DatabaseWriter.Runner.class);
    }

    public void postcheck(final String bodhi, final structures.database.Database database, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.runner(bodhi,"postcheck", database, DatabaseWriter.Postcheck.class);
    }

    //

    public void precheck(final String bodhi, final structures.database.Database database, final structures.table.Table table, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.runner(bodhi,"precheck", database, table, TableWriter.Precheck.class);
    }

    public void runner(final String bodhi, final structures.database.Database database, final structures.table.Table table, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.runner(bodhi,"runner", database, table, TableWriter.Runner.class);
    }

    public void postcheck(final String bodhi, final structures.database.Database database, final structures.table.Table table, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.runner(bodhi,"postcheck", database, table, TableWriter.Postcheck.class);
    }

    public static class System
    {
        public HashMap<String, Object> map = new HashMap<String, Object>();

        public static System reference = new System();

        public System()
        {
            System.reference = this;
        }

        public static void storage(final String bodhi00, final String bodhi01)
        {
            System.storage(bodhi00, System.pull(bodhi01));
        }

        public static void storage(final String bodhi, final Object object)
        {
            System.reference.map.put(bodhi, object);
        }

        public static Object pull(final String bodhi)
        {
            return System.reference.map.get(bodhi);
        }

        public static void runner(final String bodhi, final String value, final structures.database.Database pdatabase, final structures.table.Table ptable, final Class<?> context) throws Exception
        {
            if (context.isAssignableFrom(TableWriter.Precheck.class))
            {
                return;
            }
            else if(context.isAssignableFrom(TableWriter.Runner.class))
            {
                JSONObject database;

                JSONObject tables;

                JSONObject columns;

                JSONObject values;

                //

                database = new JSONObject();

                database.put("database", pdatabase.name);

                database.put("tables", tables = new JSONObject());

                //

                tables.put("table", ptable.name);

                tables.put("columns", columns = new JSONObject());

                tables.put("values", values = new JSONObject());

                //

                for(int i=0; i<ptable.column_names.length; i++)
                {
                    columns.put(ptable.column_names[i], ptable.column_types[i]);
                }

                //

                for(int i=0; i<ptable.column_names.length; i++)
                {
                    columns.put(ptable.value_names[i], ptable.value_values[i]);
                }

                //

                FileWriter writer = new FileWriter(new File(pdatabase.url));

                writer.write(database.toJSONString());

                writer.flush();

                writer.close();

                writer = null;
            }
            else if(context.isAssignableFrom(TableWriter.Postcheck.class))
            {
                return;
            }
        }

        public static void runner(final String bodhi, final String value, final Database pdatabase, final Class<?> context) throws Exception
        {
            if (context.isAssignableFrom(DatabaseWriter.Precheck.class))
            {
                return;
            }

            else if (context.isAssignableFrom(DatabaseWriter.Runner.class))
            {
                JSONObject database;

                JSONArray tables;

                //

                database = new JSONObject();

                database.put("database", pdatabase.name);

                database.put("tables", tables = new JSONArray());

                //

                FileWriter writer = new FileWriter(new File(pdatabase.url));

                writer.write("Trillions and trillions of dollars...");

                writer.write(database.toJSONString());

                writer.flush();

                writer.close();

                writer = null;
            }

            else if (context.isAssignableFrom(DatabaseWriter.Postcheck.class))
            {
                return;
            }
        }

        public static Boolean equality(final String bodhi, final String value, final components.database.Database database, final Class<?> context) throws Exception
        {
            return bodhi.equals(value);
        }

        public static Boolean not_null(final String bodhi) throws Exception
        {
            return System.pull(bodhi)==null;
        }
    }

    public static class DatabaseWriter
    {
        public static class Precheck {}

        public static class Runner {}

        public static class Postcheck {}
    }

    public static class TableWriter
    {
        public static class Precheck {}

        public static class Runner {}

        public static class Postcheck {}
    }
}