package org.xml;

public class Attribute extends Node
{
    public String name;

    public String value;

    //

    public Attribute(String name, Integer value)
    {
        this.name = name;

        this.value = String.valueOf(value);
    }

    public Attribute(String name, String value)
    {
        this.name = name;

        this.value = value;
    }

    public Attribute(String value)
    {
        this.value = value;
    }
}
