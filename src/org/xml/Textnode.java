package org.xml;

public class Textnode extends Node
{
    public String value = "";

    public Textnode()
    {
        this.value = "";
    }

    public Textnode(String value)
    {
        this.value = value;
    }

    public Integer size()
    {
        return this.value.equals("") ? 0 : 1;
    }
}
