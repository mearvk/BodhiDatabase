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
import system.System;
import utility.Utility;

public class Persistence extends Component
{
    public static Persistence reference;

    public SQLWriter writer = new SQLWriter();

    public SQLReader reader = new SQLReader();

    public Persistence() throws Exception
    {
        System.push("//persistence", this);

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
        public void writeXML(String bodhi, Parameter parameter, Class<?> klass)
        {
            if(bodhi.equals("//database") && klass.isAssignableFrom(CreateTableImpl.TaskRunner.class))
            {
                Database database;

                database = (Database) system.System.peek("//database");

                if(database==null)
                {
                    new ExceptionQueue().enqueue(new Exception("CreateTableImpl.TaskRunner >> Persistence.writeXML >> Database is NULL"));
                }
                else
                {
                    String databaseUrl = CreateTableImpl.Utility.getDatabaseUrl(parameter);

                    String databaseName = CreateTableImpl.Utility.getDatabaseName(parameter);

                    //

                    Utility.XMLWriter writer;

                    writer = new Utility.XMLWriter();

                    writer.create_table(databaseUrl, databaseName, CreateTableImpl.TaskRunner.class);
                }
            }

            if(bodhi.equals("//database") && klass.isAssignableFrom(CreateDatabaseImpl.TaskRunner.class))
            {
                Database database;

                database = (Database) system.System.peek("//database");

                if(database==null)
                {
                    ExceptionQueue equeue;

                    equeue = new ExceptionQueue();

                    equeue.enqueue(new Exception("CreateDatabaseImpl.TaskRunner >> Persistence.writeXML >> Database is NULL"));
                }
                else
                {
                    String databaseUrl = CreateDatabaseImpl.Utility.getDatabaseUrl(parameter);

                    String databaseName = CreateDatabaseImpl.Utility.getDatabaseName(parameter);

                    //

                    Utility.XMLWriter writer;

                    writer = new Utility.XMLWriter();

                    writer.create_database(databaseUrl, databaseName, CreateTableImpl.TaskRunner.class);
                }
            }
        }
    }

    public class SQLReader
    {
        public Object readXML(String bodhi, String dbname, Parameter parameter, Class<?> klass)
        {
            //System.message("//database", "Database <"+dbname+"> selected.");

            return null;
        }
    }
}
