package org.xml;

public class Namespace
{
    public Boolean root = false;

    public Boolean inheritor = false;

    public String prefix = "";

    public String uri = "";

    public Namespace()
    {

    }

    public Namespace(String prefix, String uri, Boolean inheritor)
    {
        this.prefix = prefix;

        this.uri = uri;

        this.inheritor = inheritor;
    }

    public Namespace(String prefix, String uri)
    {
        this.prefix = prefix;

        this.uri = uri;

        this.root = true;
    }

    public int size()
    {
        return this.prefix.equals("") ? 0 : 1;
    }
}
