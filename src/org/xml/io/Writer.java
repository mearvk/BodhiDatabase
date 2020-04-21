package org.xml.io;

import org.xml.Document;

import java.io.FileWriter;
import java.io.IOException;

public class Writer
{
    public Writer(Document document, String url)
    {
        FileWriter writer;

        try
        {
            writer = new FileWriter(url);

            writer.write(document.toXML());

            writer.flush();

            writer.close();

            writer = null;
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
    }
}
