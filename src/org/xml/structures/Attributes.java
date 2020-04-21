package org.xml.structures;

import org.xml.Attribute;

import java.util.ArrayList;

public class Attributes
{
    public ArrayList<String> names = new ArrayList();

    public ArrayList<String> values = new ArrayList();

    //

    public Attributes(Attribute...attributes)
    {

    }

    public boolean addAll(Attributes attributes)
    {
        return true;
    }

    public boolean add(Attribute attribute)
    {
        boolean result01 = this.names.add(attribute.name);

        boolean result02 = this.values.add(attribute.value);

        return result01 & result02;
    }

    public Integer size()
    {
        return this.names.size();
    }

    public Attribute get(int index)
    {
        return new Attribute(this.names.get(index), this.values.get(index));
    }
}
