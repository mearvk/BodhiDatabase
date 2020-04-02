package utility;

import cases.CreateDatabaseImpl;
import components.database.Database;
import components.persistence.Persistence;
import parameter.Parameter;

public class Writer
{
    public Object writeXML(final String bodhi, final Database database, final Parameter parameter, Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();

        persistence.writer.writeXML("//database", database, parameter, CreateDatabaseImpl.TaskRunner.class);

        return null;
    }

    public Object checkXML(final String bodhi, final Database database, final Parameter parameter, Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();

        persistence.writer.checkXML("//database", database, parameter, CreateDatabaseImpl.TaskRunner.class);

        return null;
    }
}
