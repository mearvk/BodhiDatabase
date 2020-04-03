package utility;

import cases.CreateDatabaseImpl;
import components.database.Database;
import components.persistence.Persistence;
import parameter.Parameter;
import structures.table.Table;

public class Writer
{
    public static Object writeXML(final String bodhi, final Database database, final Table table, final Parameter parameter, Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();

        persistence.writer.writeXML(bodhi, database, table, parameter, context);

        return persistence = null;
    }

    public static Object writeXML(final String bodhi, final Database database, final Parameter parameter, Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();

        persistence.writer.writeXML(bodhi, database, parameter, context);

        return persistence = null;
    }

    public static Object checkXML(final String bodhi, final Database database, final Parameter parameter, Class<?> context) throws Exception
    {
        Persistence persistence;

        persistence = new Persistence();

        persistence.writer.checkXML("//database", database, parameter, CreateDatabaseImpl.TaskRunner.class);

        return persistence = null;
    }
}
