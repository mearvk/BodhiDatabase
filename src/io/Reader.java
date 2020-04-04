package io;

import cases.CreateDatabaseImpl;
import components.database.Database;
import components.persistence.Persistence;
import parameter.Parameter;

public class Reader
{
    public Object readXML(final String bodhi, final Database database, final Parameter parameter, Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();

        persistence.reader.readXML(bodhi, database, parameter, context);

        return null;
    }

    public Object checkXML(final String bodhi, final Database database, final Parameter parameter, Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();

        //persistence.reader.checkXML("//database", database, parameter, CreateDatabaseImpl.TaskRunner.class);

        return null;
    }
}
