package io;

import components.persistence.Persistence;
import parameter.Parameter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;

import java.util.HashMap;

public class Writer
{
    public static Writer reference;

    public System system = new System();

    public Writer()
    {
        Writer.reference = this;
    }

    public Object writeXML(final String bodhi, final components.database.Database database, final structures.table.Table table, final Parameter parameter, Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();

        persistence.writer.writeXML(bodhi, database, table, this, parameter, context);

        return persistence = null;
    }

    public Object writeXML(final String bodhi, final components.database.Database database, final Parameter parameter, Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();


        return persistence = null;
    }

    public Object checkXML(final String bodhi, final components.database.Database database, final Parameter parameter, final Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();

        persistence.writer.checkXML(bodhi, database, this, parameter, context);

        return persistence = null;
    }

    //

    public void step001(final String bodhi, final components.database.Database database, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.setter("//schema/database","validate", database, Writer.Database.Step001.class);
    }

    public void step002(final String bodhi, final components.database.Database database, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.setter("//schema/database/tables","validate", database, Writer.Database.Step002.class);
    }

    public void step003(final String bodhi, final components.database.Database database, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.setter("//schema{output}","validate", database, Writer.Database.Step003.class);
    }

    //

    public void step001(final String bodhi, final components.database.Database database, final Table table, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.setter("//schema/database/table","validate", database, Writer.Table.Step001.class);
    }

    public void step002(final String bodhi, final components.database.Database database, final Table table, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.setter("//schema/database/tables/table","validate", database, Writer.Table.Step002.class);
    }

    public void step003(final String bodhi, final components.database.Database database, final Table table, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.setter("//schema{output}","validate", database, Writer.Table.Step003.class);
    }

    public static class System
    {
        public HashMap<String, Object> map = new HashMap<String, Object>();

        public static System reference = new System();

        public System()
        {
            System.reference = this;
        }

        public static void store(final String bodhi00, final String bodhi01)
        {
            System.store(bodhi00, System.pull(bodhi01));
        }

        public static void store(final String bodhi, final Object object)
        {
            System.reference.map.put(bodhi, object);
        }

        public static Object pull(final String bodhi)
        {
            return System.reference.map.get(bodhi);
        }

        public static void setter(final String bodhi, final String value, components.database.Database database, Table table, final Class<?> context) throws Exception
        {
            if (context.isAssignableFrom(Writer.Table.Step001.class))
            {
                DocumentBuilderFactory factory=null;

                DocumentBuilder builder=null;

                Document document=null;

                Element root=null;

                NodeList tables;

                //

                System.store("//document/builder/factory", factory = DocumentBuilderFactory.newInstance());

                System.store("//document/builder", builder = factory.newDocumentBuilder());

                System.store("//document", document = builder.parse(new File(database.url)));

                System.store("//schema/database", root = (Element)document.getFirstChild());

                System.store("//schema/database/tables", tables = root.getElementsByTagName("tables"));

                //

                return;
            }

            if(context.isAssignableFrom(Writer.Table.Step002.class))
            {
                //TODO ensure that //schema/database/tables/table is in correct form in DOM
            }

            if(context.isAssignableFrom(Writer.Table.Step003.class))
            {
                try //TODO write correct DOM to disk
                {
                    TransformerFactory factory;

                    Transformer transformer;

                    System.store("//transformer/factory", factory = TransformerFactory.newInstance());

                    System.store("//transformer", transformer = factory.newTransformer());

                    //

                    //System.setter("//transformer{indent}", "yes");

                    //

                    DOMSource source = new DOMSource((Document)System.pull("//document"));

                    transformer.transform(source, new StreamResult(new File(database.url)));
                }
                catch (Exception e)
                {
                    return;
                }
            }
        }

        public static void setter(final String bodhi, final String value, final components.database.Database database, final Class<?> context) throws Exception
        {
            if (context.isAssignableFrom(Writer.Database.Step001.class))
            {
                DocumentBuilderFactory factory=null;

                DocumentBuilder builder=null;

                Document document=null;

                Element root=null;

                NodeList tables;

                //

                System.store("//document/builder/factory", factory = DocumentBuilderFactory.newInstance());

                System.store("//document/builder", builder = factory.newDocumentBuilder());

                System.store("//document", document = builder.parse(new File(database.url)));

                System.store("//schema/database", root = (Element)document.getFirstChild());

                System.store("//schema/database/tables", tables = root.getElementsByTagName("tables"));

                //

                if(!root.getNodeName().equals("database")) throw new Exception();

                //

                return;
            }

            if (context.isAssignableFrom(Writer.Database.Step002.class))
            {
                Document document;

                Element root;

                //

                System.store("//document", document = (Document)System.pull("//document"));

                System.store("//schema/database", root = (Element)System.pull("//schema/database"));

                //

                return;
            }
            if (context.isAssignableFrom(Writer.Database.Step003.class))
            {
                try
                {
                    TransformerFactory factory;

                    Transformer transformer;

                    Document document;

                    //

                    System.store("//transformer/factory", factory = TransformerFactory.newInstance());

                    System.store("//transformer", transformer = factory.newTransformer());

                    System.store("//document", document = (Document)System.pull("//document"));

                    //

                    DOMSource source = new DOMSource(document);

                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

                    transformer.transform(source, new StreamResult(new File(database.url)));
                }
                catch (Exception e)
                {
                    return;
                }
            }
        }

        public static void equality(final String bodhi, final String value, final components.database.Database database, final Class<?> context) throws Exception
        {

        }
    }

    public static class Database
    {
        public static class Step001
        {

        }

        public static class Step002
        {

        }

        public static class Step003
        {

        }
    }

    public static class Table
    {
        public static class Step001
        {

        }

        public static class Step002
        {

        }

        public static class Step003
        {

        }
    }
}