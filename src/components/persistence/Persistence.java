package components.persistence;

import cases.CreateDatabaseImpl;
import cases.CreateTableImpl;
import components.Component;
import components.database.Database;
import components.persistence.handler.PersistenceCaseHandler;
import exceptions.ExceptionQueue;
import parameter.Parameter;
import structures.Queue;
import structures.SQLString;
import structures.table.Table;
import system.System;
import io.Writer;

public class Persistence extends Component
{
    public static Persistence reference;

    public SQLWriter writer = new SQLWriter();

    public SQLReader reader = new SQLReader();

    public Persistence() throws Exception
    {
        System.store("//persistence", this);

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

        public void writeXML(String bodhi, Database database, Writer writer, Parameter parameter, Class<?> context) throws Exception
        {
            if(context.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
            {
                try
                {
                    writer.step001(bodhi, database, parameter, context);

                    writer.step002(bodhi, database, parameter, context);

                    writer.step003(bodhi, database, parameter, context);
                }
                catch(Exception e)
                {

                }
            }
        }

        public void writeXML(String bodhi, Database database, Table table, Writer writer, Parameter parameter, Class<?> context) throws Exception
        {
            if(context.isAssignableFrom(CreateTableImpl.TaskRunner.class))
            {
                writer.step001(bodhi, database, parameter, context);

                writer.step002(bodhi, database, parameter, context);

                writer.step003(bodhi, database, parameter, context);
            }

            if(context.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
            {


                writer.writeXML(bodhi, database, table, parameter, context);
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
