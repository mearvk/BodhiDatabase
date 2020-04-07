package components.persistence;

import cases.CreateDatabaseImpl;
import cases.CreateTableImpl;
import components.Component;
import structures.Queue;
import structures.SQLString;
import structures.database.Database;
import components.persistence.handler.PersistenceCaseHandler;
import exceptions.ExceptionQueue;
import parameter.Parameter;
import system.System;
import io.Writer;

public class Persistence extends Component
{
    public static Persistence reference;

    public SQLWriter writer = new SQLWriter();

    public SQLReader reader = new SQLReader();

    public Persistence() throws Exception
    {
        System.storage("//persistence", this);

        Persistence.reference = this;
    }

    public void write(String bodhi, Class<?> klass)
    {

    }

    public static class Thread extends java.lang.Thread
    {
        public Queue<SQLString> queue = new Queue<SQLString>();

        public Boolean running = true;

        @Override
        public void run()
        {
            try
            {
                while (running)
                {
                    try
                    {
                        if (this.queue.peek() == null)
                        {
                            java.lang.Thread.sleep(20, 0);

                            continue;
                        }

                        else new PersistenceCaseHandler(this.queue);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            catch (Exception e)
            {
                ExceptionQueue queue;

                queue = new ExceptionQueue();

                queue.enqueue(e, e.getMessage());
            }
        }
    }

    public class SQLWriter
    {
        public void validateXML(String bodhi, Parameter parameter, Class<?> klass)
        {
            //TODO validate XML
        }

        public Object checkXML(String bodhi, Database database, Writer writer, Parameter parameter, Class<?> context)
        {
            return null;
        }

        public Object checkXML(String bodhi, String dbname, String tablename, Writer writer, Parameter parameter, Class<?> context)
        {
            java.lang.System.out.println("TODO: IMPL CHECKXML IN PERSISTENCE");

            return null;
        }

        public void writeXML(String bodhi, Database database, Parameter parameter, Class<?> context) throws Exception
        {
            if(context.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
            {
                Writer writer = new Writer();

                writer.precheck(bodhi, database, parameter, context);

                writer.runner(bodhi, database, parameter, context);

                writer.postcheck(bodhi, database, parameter, context);
            }
         }

        public void writeXML(String bodhi, structures.database.Database database, structures.table.Table table, Parameter parameter, Class<?> context) throws Exception
        {
            if(context.isAssignableFrom(CreateTableImpl.TaskRunner.class))
            {
                Writer writer = new Writer();

                writer.precheck(bodhi, database, table, parameter, context);

                writer.runner(bodhi, database, table, parameter, context);

                writer.postcheck(bodhi, database, table, parameter, context);
            }
        }
    }

    public class SQLReader
    {
        public Object readXML(String bodhi, Database database, Parameter parameter, Class<?> klass) throws Exception
        {
            //System.message("//database", "Database <"+dbname+"> selected.");

            return null;
        }
    }
}
