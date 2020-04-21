package org.xml.harness;

import org.xml.*;
import org.xml.io.Writer;
import org.xml.structures.Elements;

import java.io.FileWriter;

public class XMLHarness
{
    public static class Test001
    {
        public Test001()
        {
            try
            {
                Document document;

                Element tables;

                Element column01, column02, column03, column04, column05, column06, column07, column08, column09;

                Element table01, table02, table03;



                document = new Document();

                //

                tables = document.root.addElement(new Element("tables"));

                //

                table01 = tables.addElement(new Element("table", new Namespace("a","https://ceo.ibm.com")));

                table02 = tables.addElement(new Element("table"));

                table03 = tables.addElement(new Element("table"));


                column01 = table01.addElement(column01 = new Element("column"));

                column02 = table01.addElement(column02 = new Element("column"));

                column03 = table01.addElement(column03 = new Element("column"));


                //

                column04 = table02.addElement(column04 = new Element("column"));

                column05 = table02.addElement(column05 = new Element("column"));

                column06 = table02.addElement(column06 = new Element("column"));

                //

                column07 = table03.addElement(column07 = new Element("column"));

                column08 = table03.addElement(column08 = new Element("column"));

                column09 = table03.addElement(column09 = new Element("column"));

                //


                FileWriter writer;

                writer = new FileWriter("C:\\Users\\Mr. Max Rupplin\\Desktop\\org.xml.xml\\output.org.xml.xml");

                writer.write(document.toXML());

                writer.flush();

                writer.close();

                writer = null;
            }
            catch (Exception e)
            {
                System.err.println(e);
            }
        }
    }

    public static class Test002
    {
        public Test002()
        {
            try
            {
                Document document;

                Element tables;

                Element column01, column02, column03, column04, column05, column06, column07, column08, column09;

                Element table01, table02, table03;


                document = new Document();

                //

                tables = document.root.addElement(new Element("tables"));

                //

                table01 = tables.addElement(new Element("table"));

                table02 = tables.addElement(new Element("table"));

                table03 = tables.addElement(new Element("table"));

                //

                table01.addAttribute(new Attribute("id","01"));

                table02.addAttribute(new Attribute("id","02"));

                table03.addAttribute(new Attribute("id","03"));

                //

                column01 = table01.addElement(column01 = new Element("column"));

                column02 = table01.addElement(column02 = new Element("column"));

                column03 = table01.addElement(column03 = new Element("column"));

                //

                column01.addAttribute(new Attribute("name","descriptor"));

                column02.addAttribute(new Attribute("name","descriptor"));

                column03.addAttribute(new Attribute("name","descriptor"));


                //

                column04 = table02.addElement(column04 = new Element("column"));

                column05 = table02.addElement(column05 = new Element("column"));

                column06 = table02.addElement(column06 = new Element("column"));

                //

                column04.addAttribute(new Attribute("name","descriptor"));

                column05.addAttribute(new Attribute("name","descriptor"));

                column06.addAttribute(new Attribute("name","descriptor"));

                //

                column07 = table03.addElement(column07 = new Element("column"));

                column08 = table03.addElement(column08 = new Element("column"));

                column09 = table03.addElement(column09 = new Element("column"));

                //

                column07.addAttribute(new Attribute("name","descriptor"));

                column08.addAttribute(new Attribute("name","descriptor"));

                column09.addAttribute(new Attribute("name","descriptor"));


                FileWriter writer;

                writer = new FileWriter("C:\\Users\\Mr. Max Rupplin\\Desktop\\org.xml.xml\\output.org.xml.xml");

                writer.write(document.toXML());

                writer.flush();

                writer.close();

                writer = null;
            }
            catch (Exception e)
            {
                System.err.println(e);
            }
        }
    }

    public static class Test003
    {
        public Test003()
        {
            try
            {
                Document document;

                Element tables;

                Element column01, column02, column03, column04, column05, column06, column07, column08, column09;

                Element table01, table02, table03;


                document = new Document(new Root("database"));

                //

                tables = document.root.addElement(new Element("tables"));

                //

                table01 = tables.addElement(new Element("table"));

                table02 = tables.addElement(new Element("table"));

                table03 = tables.addElement(new Element("table"));

                //

                table01.addAttribute(new Attribute("id","01"));

                table02.addAttribute(new Attribute("id","02"));

                table03.addAttribute(new Attribute("id","03"));

                //

                column01 = table01.addElement(column01 = new Element("column"));

                column02 = table01.addElement(column02 = new Element("column"));

                column03 = table01.addElement(column03 = new Element("column"));

                //

                column01.addAttribute(new Attribute("name","descriptor"));

                column01.addAttribute(new Attribute("type","varchar(255)"));

                column01.addTextnode(new Textnode("{textnode01}"));

                //

                column02.addAttribute(new Attribute("name","descriptor"));

                column02.addAttribute(new Attribute("type","varchar(255)"));

                column02.addTextnode(new Textnode("{textnode02}"));

                //

                column03.addAttribute(new Attribute("name","descriptor"));

                column03.addAttribute(new Attribute("type","varchar(255)"));

                column03.addTextnode(new Textnode("{textnode03}"));

                //

                column04 = table02.addElement(column04 = new Element("column"));

                column05 = table02.addElement(column05 = new Element("column"));

                column06 = table02.addElement(column06 = new Element("column"));

                //

                column04.addAttribute(new Attribute("name","descriptor"));

                column05.addAttribute(new Attribute("name","descriptor"));

                column06.addAttribute(new Attribute("name","descriptor"));

                //

                column07 = table03.addElement(column07 = new Element("column"));

                column08 = table03.addElement(column08 = new Element("column"));

                column09 = table03.addElement(column09 = new Element("column"));

                //

                column07.addAttribute(new Attribute("name","descriptor"));

                column08.addAttribute(new Attribute("name","descriptor"));

                column09.addAttribute(new Attribute("name","descriptor"));


                FileWriter writer;

                writer = new FileWriter("C:\\Users\\Mr. Max Rupplin\\Desktop\\org.xml.xml\\output.org.xml.xml");

                writer.write(document.toXML());

                writer.flush();

                writer.close();

                writer = null;
            }
            catch (Exception e)
            {
                System.err.println(e);
            }
        }
    }

    public static class Test004
    {
        public Test004()
        {
            try
            {
                Document document;

                Element tables;

                Element column01, column02, column03, column04, column05, column06, column07, column08, column09;

                Element table01, table02, table03;


                document = new Document(new Root("database"));

                //

                tables = document.root.addElement(new Element("tables"));

                //

                table01 = tables.addElement(new Element("table"));

                table02 = tables.addElement(new Element("table"));

                table03 = tables.addElement(new Element("table"));

                //

                table01.addAttribute(new Attribute("id","01"));

                table02.addAttribute(new Attribute("id","02"));

                table03.addAttribute(new Attribute("id","03"));

                //

                column01 = table01.addElement(column01 = new Element("column"));

                column02 = table01.addElement(column02 = new Element("column"));

                column03 = table01.addElement(column03 = new Element("column"));

                //

                column01.addAttribute(new Attribute("name","descriptor"));

                column01.addAttribute(new Attribute("type","varchar(255)"));

                column01.addTextnode(new Textnode("{textnode01}"));

                //

                column02.addAttribute(new Attribute("name","descriptor"));

                column02.addAttribute(new Attribute("type","varchar(255)"));

                column02.addTextnode(new Textnode("{textnode02}"));

                //

                column03.addAttribute(new Attribute("name","descriptor"));

                column03.addAttribute(new Attribute("type","varchar(255)"));

                column03.addTextnode(new Textnode("{textnode03}"));

                //

                column04 = table02.addElement(column04 = new Element("column"));

                column05 = table02.addElement(column05 = new Element("column"));

                column06 = table02.addElement(column06 = new Element("column"));

                //

                column04.addAttribute(new Attribute("name","descriptor"));

                column05.addAttribute(new Attribute("name","descriptor"));

                column06.addAttribute(new Attribute("name","descriptor"));

                //

                column07 = table03.addElement(column07 = new Element("column"));

                column08 = table03.addElement(column08 = new Element("column"));

                column09 = table03.addElement(column09 = new Element("column"));

                //

                column07.addAttribute(new Attribute("name","descriptor"));

                column08.addAttribute(new Attribute("name","descriptor"));

                column09.addAttribute(new Attribute("name","descriptor"));


                FileWriter writer;

                writer = new FileWriter("C:\\Users\\Mr. Max Rupplin\\Desktop\\org.xml.xml\\output.org.xml.xml");

                writer.write(document.toXML());

                writer.flush();

                writer.close();

                writer = null;
            }
            catch (Exception e)
            {
                System.err.println(e);
            }
        }
    }

    public static class Test005
    {
        public Test005()
        {
            try
            {
                Document document;

                Element users;

                Element user01, user02, user03;

                Element firstname01, firstname02, firstname03;

                Element lastname01, lastname02, lastname03;

                Element occupation01, occupation02, occupation03;


                document = new Document(new Root("users"));

                //

                user01 = document.root.addElement(new Element("user"));

                user02 = document.root.addElement(new Element("user"));

                user03 = document.root.addElement(new Element("user"));

                //

                user01 = user01.setId(new Attribute("01"));

                user02 = user02.setId(new Attribute("02"));

                user03 = user03.setId(new Attribute("03"));

                //

                user01.addElement(firstname01 = new Element("firstname"));

                user01.addElement(lastname01 = new Element("lastname"));

                user01.addElement(occupation01 = new Element("occupation"));

                //

                user02.addElement(firstname02 = new Element("firstname"));

                user02.addElement(lastname02 = new Element("lastname"));

                user02.addElement(occupation02 = new Element("occupation"));

                //

                user03.addElement(firstname03 = new Element("firstname"));

                user03.addElement(lastname03 = new Element("lastname"));

                user03.addElement(occupation03 = new Element("occupation"));

                //

                firstname01.addTextnode(new Textnode("Peter"));

                firstname02.addTextnode(new Textnode("Martin"));

                firstname03.addTextnode(new Textnode("Lucy"));

                //

                lastname01.addTextnode(new Textnode("Brown"));

                lastname02.addTextnode(new Textnode("Smith"));

                lastname03.addTextnode(new Textnode("Gordon"));

                //

                occupation01.addTextnode(new Textnode("Programmer"));

                occupation02.addTextnode(new Textnode("Accountant"));

                occupation03.addTextnode(new Textnode("Teacher"));

                //

                Writer writer = new Writer(document, "C:\\Users\\Mr. Max Rupplin\\Desktop\\org.xml.xml\\output.org.xml.xml");
                
                //
                
                Elements elements = document.root.getChildren();
                
                for(int i=0; i<elements.size(); i++)
                {
                    Element element = elements.get(i);

                    Textnode fname = element.getChild("firstname").getTextnode();

                    Textnode lname = element.getChild("lastname").getTextnode();

                    Textnode occup = element.getChild("occupation").getTextnode();
                }
            }
            catch (Exception e)
            {
                System.err.println(e);
            }
        }
    }

    public static class Test006 {
        public Test006() {
            try {
                Document document;

                Element users;

                Element table01, table02;

                Element tr01;

                Element td01, td02;

                Element name01;

                Element width01;

                Element length01;

                //

                document = new Document(new Root("tables"));

                //

                table01 = document.root.addElement(table01 = new Element("table", new Namespace("a", "http://www.w3.org/TR/html4/")));

                table02 = document.root.addElement(table02 = new Element("table", new Namespace("b", "https://www.w3schools.com/furniture")));

                //

                tr01 = table01.addElement(tr01 = new Element("tr"));

                //

                td01 = tr01.addElement(td01 = new Element("td", new Namespace("c", "jgp://mearvk.org/projects")));

                td02 = tr01.addElement(td02 = new Element("td"));

                //

                td01.addTextnode(new Textnode("Apples"));

                td02.addTextnode(new Textnode("Bananas"));

                //

                name01 = table02.addElement(name01 = new Element("name"));

                width01 = table02.addElement(width01 = new Element("width"));

                length01 = table02.addElement(length01 = new Element("length"));

                //

                name01.addTextnode(new Textnode("African Coffee Table"));

                width01.addTextnode(new Textnode("80"));

                length01.addTextnode(new Textnode("120"));

                //

                Writer writer = new Writer(document, "C:\\Users\\Mr. Max Rupplin\\Desktop\\org.xml.xml\\output.org.xml.xml");
            }
            catch (Exception e)
            {
                System.err.println(e);
            }
        }
    }

    public static class Test007
    {
        public Test007()
        {
            try
            {
                Document document;

                Element table01, table02, table03;

                Element tr01;

                Element td01, td02;

                Element name01;

                Element width01;

                Element length01;

                Element column01, column02, column03;

                Element value01, value02, value03;


                //

                document = new Document(new Root("tables"));

                //

                table01 = document.root.addElement(table01 = new Element("table", new Namespace("a", "http://www.w3.org/TR/html4/")));

                table02 = document.root.addElement(table02 = new Element("table", new Namespace("b", "https://www.w3schools.com/furniture")));

                table03 = document.root.addElement(table03 = new Element("table"));

                //

                tr01 = table01.addElement(tr01 = new Element("tr"));

                //

                td01 = tr01.addElement(td01 = new Element("td", new Namespace("c", "https://mearvk.org/projects")));

                td02 = tr01.addElement(td02 = new Element("td"));

                //

                td01.addTextnode(new Textnode("Apples"));

                td02.addTextnode(new Textnode("Bananas"));

                //

                name01 = table02.addElement(name01 = new Element("name", new Namespace("e", "https://org.namespace.venkat.java")));

                width01 = table02.addElement(width01 = new Element("width"));

                length01 = table02.addElement(length01 = new Element("length"));

                //

                name01.addTextnode(new Textnode("African Coffee Table"));

                width01.addTextnode(new Textnode("80"));

                length01.addTextnode(new Textnode("120"));

                //

                column01 = table03.addElement(column01 = new Element("column"));

                column02 = table03.addElement(column02 = new Element("column"));

                column03 = table03.addElement(column03 = new Element("column"));

                //

                value01 = table03.addElement(value01 = new Element("value"));

                value02 = table03.addElement(value02 = new Element("value"));

                value03 = table03.addElement(value03 = new Element("value"));

                //

                Writer writer = new Writer(document, "C:\\Users\\Mr. Max Rupplin\\Desktop\\org.xml.xml\\output.org.xml.xml");
            }
            catch (Exception e)
            {
                System.err.println(e);
            }
        }
    }
}

