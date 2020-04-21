package org.xml.structures;

import org.xml.Element;

import java.util.ArrayList;

public class Elements
{
    public ArrayList<Element> elements = new ArrayList<>();

    public Element append(Element element)
    {
        this.elements.add(element);

        return element;
    }


    public Element add(Element element)
    {
        this.elements.add(element);

        return element;
    }

    public Element add(Element...elements)
    {
        return elements[0];
    }

    public Element addAll(Elements elements)
    {
        return elements.getFirstChild();
    }

    public Element getFirstChild()
    {
        return elements.get(0);
    }

    public Integer size()
    {
        return this.elements.size();
    }

    public Element get(int index)
    {
        return this.elements.get(index);
    }
}
