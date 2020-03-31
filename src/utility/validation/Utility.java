package utility.validation;


import constants.DatabaseConstants;
import contexts.CreateDatabaseImplContext;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;

public class Utility
{
    public static class XMLReader
    {
        public XMLReader(String fileURL, String dbname, Class<?> klass)
        {

        }
    }

    public static class XMLWriter
    {
        public XMLWriter(String fileURL, String dbname, Class<?> klass)
        {
            if(klass.isAssignableFrom(CreateDatabaseImplContext.TaskRunnerContext.class))
            {
                //File file=null;

                try
                {
                    File file = new File(fileURL);

                    FileWriter writer = new FileWriter(new File(fileURL));

                    writer.write("");

                    writer.flush();

                    writer.close();

                    writer = null;

                    //

                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

                    DocumentBuilder builder = factory.newDocumentBuilder();

                    Document document = builder.newDocument();

                    //

                    Element root = document.createElement("database");

                    Element meta = document.createElement("meta");

                    Element tables = document.createElement("tables");

                    //

                    document.appendChild(root);

                    root.appendChild(meta);

                    root.appendChild(tables);

                    //

                    Attr attr;

                    //

                    attr = document.createAttribute("name");

                    attr.setValue(dbname);

                    root.setAttributeNode(attr);

                    //

                    attr = document.createAttribute("version");

                    attr.setValue("1.0");

                    meta.setAttributeNode(attr);

                    //

                    TransformerFactory transformerFactory = TransformerFactory.newInstance();

                    Transformer transformer = transformerFactory.newTransformer();

                    DOMSource source = new DOMSource(document);

                    StreamResult result = new StreamResult(file);

                    transformer.transform(source, result);

                    //

                    StreamResult consoleResult = new StreamResult(System.out);

                    transformer.transform(source, consoleResult);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
