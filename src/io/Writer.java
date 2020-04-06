package io;

import components.persistence.Persistence;
import exceptions.ExceptionQueue;
import org.w3c.dom.*;
import parameter.Parameter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import java.io.File;

import java.io.FileNotFoundException;
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
        System.runner(bodhi,"precheck", database, Writer.Database.Step001.class);
    }

    public void runner(final String bodhi, final structures.database.Database database, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.runner(bodhi,"runner", database, Writer.Database.Step002.class);
    }

    public void postcheck(final String bodhi, final structures.database.Database database, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.runner(bodhi,"postcheck", database, Writer.Database.Step003.class);
    }

    //

    public void precheck(final String bodhi, final structures.database.Database database, final structures.table.Table table, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.runner(bodhi,"precheck", database, table, Writer.Table.Step001.class);
    }

    public void runner(final String bodhi, final structures.database.Database database, final structures.table.Table table, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.runner(bodhi,"runner", database, table, Writer.Table.Step002.class);
    }

    public void postcheck(final String bodhi, final structures.database.Database database, final structures.table.Table table, final Parameter parameter, final Class<?> context) throws Exception
    {
        System.runner(bodhi,"postcheck", database, table, Writer.Table.Step003.class);
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
            if (context.isAssignableFrom(Writer.Table.Step001.class))
            {
                DocumentBuilderFactory factory=null;

                DocumentBuilder builder=null;

                Document document=null;

                Element root=null;

                Element tables;

                NodeList nodelist;

                //

                try
                {
                    System.storage("//document/builder/factory", factory = DocumentBuilderFactory.newInstance());

                    System.storage("//document/builder", builder = factory.newDocumentBuilder());

                    System.storage("//document", document = builder.parse(new File(pdatabase.url)));

                    System.storage("//schema/database", root = (Element) document.getFirstChild());

                    System.storage("//schema/database/tables@element", tables = (Element) root.appendChild(document.createElement("tables")));

                    System.storage("//schema/database/tables@nodelist", nodelist = (NodeList)root.getElementsByTagName("tables"));
                }
                catch (FileNotFoundException fnfe)
                {
                    System.storage("//document", document = builder.newDocument());

                    System.storage("//schema/database", root = (Element) document.appendChild(document.createElement("database")));

                    System.storage("//schema/database/tables@element", tables = (Element) root.appendChild(document.createElement("tables")));

                    System.storage("//schema/database/tables@nodelist", nodelist = (NodeList) root.getElementsByTagName("tables"));
                }
                catch (Exception e)
                {
                    ExceptionQueue.reference.enqueue(e, e.getMessage());
                }

                return;
            }
            else if(context.isAssignableFrom(Writer.Table.Step002.class))
            {
                Document document;

                Element root;

                Element table;

                Element tables;

                Attr name;

                //

                System.storage("//document", document = (Document) System.pull("//document"));

                System.storage("//schema/database", root = (Element) System.pull("//schema/database"));

                System.storage("//schema/database/tables@element", tables = (Element) System.pull("//schema/database/tables@element"));

                //

                XPath xPath =  XPathFactory.newInstance().newXPath();

                NodeList nodelist = (NodeList) xPath.compile("/database/tables/table").evaluate(document, XPathConstants.NODESET);

                if(nodelist.getLength()==0)
                {
                    tables.appendChild(table = document.createElement("table"));

                    table.setAttributeNode(name = document.createAttribute("name"));

                    name.setValue(ptable.name);
                }
                else if(nodelist.getLength()==1)
                {
                    table = (Element)nodelist.item(0);

                    name = table.getAttributeNode("name");

                    name.setValue(ptable.name);
                }
                else if(nodelist.getLength()>1)
                {
                    for(int i=1; i<nodelist.getLength(); i++)
                    {
                        document.removeChild(nodelist.item(i));
                    }

                    table = (Element)nodelist.item(0);

                    name = table.getAttributeNode("name");

                    name.setValue(ptable.name);
                }

                java.lang.System.out.println("Document had "+nodelist.getLength()+" tables matches.");

                return;
            }

            if(context.isAssignableFrom(Writer.Table.Step003.class))
            {
                try
                {
                    TransformerFactory factory;

                    Transformer transformer;

                    Document document;

                    //

                    System.storage("//transformer/factory", factory = TransformerFactory.newInstance());

                    System.storage("//transformer", transformer = factory.newTransformer());

                    System.storage("//document", document = (Document) System.pull("//document"));

                    //

                    DOMSource source = new DOMSource(document);

                    transformer.transform(source, new StreamResult(new File(pdatabase.url)));
                }
                catch (Exception e)
                {
                    return;
                }
            }
        }

        public static void runner(final String bodhi, final String value, final structures.database.Database database, final Class<?> context) throws Exception
        {
            if (context.isAssignableFrom(Writer.Database.Step001.class))
            {
                DocumentBuilderFactory factory=null;

                DocumentBuilder builder=null;

                Document document=null;

                Element root=null;

                NodeList tables;

                //

                try
                {
                    System.storage("//document/builder/factory", factory = DocumentBuilderFactory.newInstance());

                    System.storage("//document/builder", builder = factory.newDocumentBuilder());

                    System.storage("//document", document = builder.parse(new File(database.url)));

                    System.storage("//schema/database", root = (Element) document.getFirstChild());

                    System.storage("//schema/database/tables", tables = (NodeList)root.getElementsByTagName("tables"));
                }
                catch (Exception e)
                {
                    if(e instanceof FileNotFoundException)
                    {
                        System.storage("//document", document = builder.newDocument());

                        System.storage("//schema/database", root = (Element) document.appendChild(document.createElement("database")));

                        System.storage("//schema/database/tables{pre}", root.appendChild(document.createElement("tables")));

                        System.storage("//schema/database/tables", tables = (NodeList) root.getElementsByTagName("tables"));
                    }
                    else ExceptionQueue.reference.enqueue(e, e.getMessage());
                }

                //

                return;
            }

            if (context.isAssignableFrom(Writer.Database.Step002.class))
            {
                Document document;

                Element root;

                //

                System.storage("//document", document = (Document) System.pull("//document"));

                System.storage("//schema/database", root = (Element) System.pull("//schema/database"));

                //

                Attr name;

                root.setAttributeNode(name = document.createAttribute("name"));

                name.setValue(database.name);

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

                    System.storage("//transformer/factory", factory = TransformerFactory.newInstance());

                    System.storage("//transformer", transformer = factory.newTransformer());

                    System.storage("//document", document = (Document)System.pull("//document"));

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

        public static Boolean equality(final String bodhi, final String value, final components.database.Database database, final Class<?> context) throws Exception
        {
            return bodhi.equals(value);
        }

        public static Boolean not_null(final String bodhi) throws Exception
        {
            return System.pull(bodhi)==null;
        }
    }

    public static class Database
    {
        public static class Step001 {}

        public static class Step002 {}

        public static class Step003 {}
    }

    public static class Table
    {
        public static class Step001 {}

        public static class Step002 {}

        public static class Step003 {}
    }
}