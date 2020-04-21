package io;

import components.persistence.Persistence;
import org.xml.Attribute;
import org.xml.Document;
import org.xml.Element;
import org.xml.Root;
import parameter.Parameter;
import structures.database.Database;

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
                Document document;

                Element tables;

                Element table01, table02, table03;

                Element column01, column02, column03, column04, column05, column06, column07, column08, column09;

                //

                document = new Document(new Root("database"));

                //

                document.root.addAttribute(new Attribute("name", pdatabase.name));

                document.root.addElement(tables = new Element("tables"));

                //

                tables.addElement(table01 = new Element("table"));

                tables.addElement(table02 = new Element("table"));

                tables.addElement(table03 = new Element("table"));

                //

                //table01.addElement();

                /*
                JSONObject root = new JSONObject();

                JSONObject database = new JSONObject();

                JSONObject tables = new JSONObject();

                JSONObject table = new JSONObject();

                JSONObject columns = new JSONObject();

                JSONObject values = new JSONObject();

                //

                root.put("database", database);

                    database.put("name", pdatabase.name);

                    database.put("tables", tables);

                        tables.put("table", table);

                            table.put("columns", columns);

                            table.put("name", ptable.name);

                //

                String name, type;

                for(int i=0; i<ptable.column_names.length; i++)
                {
                    columns.put(ptable.column_names[i], ptable.column_types[i]);
                }

                //

                FileWriter writer = new FileWriter(new File(pdatabase.uri));

                writer.write(database.toJSONString());

                writer.flush();

                writer.close();

                writer = null;


                 */
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
                /*
                JSONObject database;

                JSONArray tables;

                //

                database = new JSONObject();

                database.put("database", pdatabase.name);

                database.put("tables", tables = new JSONArray());

                //

                FileWriter writer = new FileWriter(new File(pdatabase.uri));

                writer.write(database.toJSONString());

                writer.flush();

                writer.close();

                writer = null;
                */

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