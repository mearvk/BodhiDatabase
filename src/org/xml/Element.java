package org.xml;

import org.xml.structures.Attributes;
import org.xml.structures.Elements;

public class Element extends Node
{
    public String name;

    public Namespace namespace = new Namespace();

    public Textnode textnode = new Textnode();

    public Elements children = new Elements();

    public Attributes attributes = new Attributes();

    //

    public Element(String name)
    {
        this.name = name;
    }

    public Element(String name, Namespace namespace)
    {
        this.name = name;

        this.namespace = namespace;
    }

    //

    public Attribute getAttribute(String name)
    {
        Attribute attribute;

        for(int i=0; i<this.attributes.size(); i++)
        {
            attribute = this.attributes.get(i);

            if(attribute.name.equals(name))
            {
                return attribute;
            }
        }

        return null;
    }

    public Attributes getAttributes(String name)
    {
        Attribute attribute;

        Attributes attributes = new Attributes();

        for(int i=0; i<this.attributes.size(); i++)
        {
            if(name.equals((attribute = this.attributes.get(i)).name))
            {
                attributes.add(attribute);
            }
        }

        return attributes;
    }

    public Element getChild(String tagname)
    {
        Element element = null;

        for(int i=0; i<this.children.size(); i++)
        {
            if(tagname.equals((element = children.get(i)).name))
            {
                return element;
            }
        }

        return null;
    }

    public Elements getChildren(String tagname)
    {
        Element element;

        Elements elements = new Elements();

        for(int i=0; i<this.children.size(); i++)
        {
            if(tagname.equals((element = this.children.get(i)).name))
            {
                elements.add(element);
            }
        }

        return elements;
    }

    public Element childAt(int index)
    {
        return this.children.get(index);
    }

    public Elements getChildren()
    {
        return children;
    }

    public Attributes getAttributes()
    {
        return attributes;
    }

    public Textnode getTextnode()
    {
        return textnode;
    }

    public Boolean isNotNamespaceInheritor()
    {
        return !this.namespace.inheritor;
    }

    public Boolean isNotNamespaceRoot()
    {
        return !this.namespace.root;
    }

    public Boolean isNamespaceRoot()
    {
        return this.namespace.root;
    }

    public Element setInheritedNamespace(Namespace namespace)
    {
        this.namespace = namespace;

        return this;
    }

    public Element setNamespace(Namespace namespace)
    {
        this.namespace = namespace;

        return this;
    }

    public Element setId(Attribute attribute)
    {
        this.attributes.add(new Attribute("id", attribute.value));

        return this;
    }

    public Element addTextnode(Textnode textnode)
    {
        this.textnode = textnode;

        return this;
    }

    public Element addAttributes(Attributes attributes)
    {
        this.attributes.addAll(attributes);

        return this;
    }

    public Element addAttribute(Attribute attribute)
    {
        this.attributes.add(attribute);

        return this;
    }

    public Element addElement(Element element)
    {
        this.children.add(element);

        return element;
    }

    public Elements addElements(Elements elements)
    {
        this.children.addAll(elements);

        return elements;
    }

    public Element addElement(Element element, Attributes attributes)
    {
        this.children.add(element);

        this.attributes.addAll(attributes);

        return this;
    }

    public boolean hasNamespace()
    {
        return this.namespace.size()>0;
    }

    public boolean hasTextnode()
    {
        return this.textnode.size()>0;
    }

    public boolean hasChildren()
    {
        return this.children.size()>0;
    }

    public boolean hasAttributes()
    {
        return this.attributes.size()>0;
    }
}
