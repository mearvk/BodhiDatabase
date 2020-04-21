package org.xml;

import org.xml.structures.Attributes;
import org.xml.structures.DocumentAttributes;

public class Document
{
    public Root root;

    public Attributes attributes;

    public DocumentAttributes document_attributes;

    //

    public Document()
    {
        this.root = new Root();
    }

    public Document(Root root)
    {
        this.root = root;
    }

    public Document(Root root, Attributes attributes)
    {
        this.root = root;
    }

    public Document(Root root, Attributes attributes, DocumentAttributes docattributes)
    {
        this.root = root;
    }

    //

    public String toXML()
    {
        String xml;

        System.out.println(xml = traverseXML(this.root,"",0));

        return xml;
    }

    protected String indent(Integer depth)
    {
        String string = "";

        for(int i=0; i<depth; i++)
        {
            string += "\t";
        }

        return string;
    }

    protected String traverseXML(Element element, String string, Integer breadth)
    {
        breadth++;

        if(element.isNamespaceRoot())
        {
            string = "<"+element.namespace.prefix+":"+element.name+" xmlns:"+element.namespace.prefix+"=\""+element.namespace.uri+"\"";
        }
        else if(element.hasNamespace())
        {
            string = "<"+element.namespace.prefix+":"+element.name;
        }
        else
        {
            string = "<"+element.name;
        }

        if(element.hasAttributes())
        {
            for(int i=0; i<element.attributes.size(); i++)
            {
                Attribute attribute;

                attribute = element.attributes.get(i);

                string = string + " "+attribute.name +"=\""+attribute.value+"\"";
            }
        }

        string = string + ">\n";

        if(element.hasTextnode())
        {
            string = string + indent(breadth) + element.textnode.value+"\n";
        }

        if(element.hasChildren())
        {
            for(int i=0; i<element.children.size(); i++)
            {
                Element child = element.childAt(i);

                if(element.hasNamespace())
                {
                    if(child.isNotNamespaceRoot())
                    {
                        child = child.setInheritedNamespace(new Namespace(element.namespace.prefix, element.namespace.uri, true));
                    }
                }

                string = string + indent(breadth) + traverseXML(child, child.name, breadth);
            }
        }

        if(element.hasNamespace())
        {
            return string + indent(breadth-1) + "</"+element.namespace.prefix+":"+element.name+">\n";
        }
        else return string + indent(breadth-1) + "</"+element.name +">\n";
    }
}

/*
    protected String traverseXML(Element element, String string, Integer breadth)
    {
        breadth++;

        string = "<"+element.name; //namespace here

        if(element.hasAttributes())
        {
            for(int i=0; i<element.attributes.size(); i++)
            {
                Attribute attribute;

                attribute = element.attributes.get(i);

                string = string + " "+attribute.name +"=\""+attribute.value+"\"";
            }
        }

        string = string + ">\n";

        if(element.hasTextnode())
        {
            string = string + indent(breadth) + element.textnode.value+"\n";
        }

        if(element.hasChildren())
        {
            for(int i=0; i<element.children.size(); i++)
            {
                string = string + indent(breadth) + traverseXML(element.children.get(i), element.name, breadth);
            }
        }

        return string + indent(breadth-1) + "</"+element.name +">\n";
    }

 */