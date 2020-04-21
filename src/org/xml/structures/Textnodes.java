package org.xml.structures;

import org.xml.Textnode;

import java.util.ArrayList;

public class Textnodes
{
    ArrayList<Textnode> textnodes = new ArrayList<Textnode>();

    public Textnode append(Textnode textnode)
    {
        this.textnodes.add(textnode);

        return textnode;
    }

    public Textnode add(Textnode element)
    {
        this.textnodes.add(element);

        return element;
    }

    public Textnode add(Textnode...elements)
    {
        return elements[0];
    }

    public Textnode addAll(Elements elements)
    {
        return textnodes.get(0);
    }

    public Textnode getFirstChild()
    {
        return textnodes.get(0);
    }

    public Integer size()
    {
        return this.textnodes.size();
    }

    public Textnode get(int index)
    {
        return this.textnodes.get(index);
    }
}
