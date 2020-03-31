package components.persistence;

import cases.CreateDatabaseImpl;
import components.Component;
import components.persistence.handler.PersistenceCaseHandler;
import constants.DatabaseConstants;
import contexts.CreateDatabaseImplContext;
import exceptions.ExceptionQueue;
import org.json.*;
import parameter.Parameter;
import structures.Queue;
import structures.SQLString;
import system.System;
import utility.validation.Utility;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;

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

    public void read(String bodhi, Parameter parameter, Class<?> klass)
    {
        if(bodhi.equals("//database") && klass.isAssignableFrom(CreateDatabaseImplContext.TaskRunnerContext.class))
        {
            this.reader.readXML(bodhi, CreateDatabaseImpl.Utility.getDatabaseName(parameter), klass);
        }
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
            if(bodhi.equals("//database") && klass.isAssignableFrom(CreateDatabaseImplContext.TaskRunnerContext.class))
            {
                Utility.XMLWriter writer = new Utility.XMLWriter(CreateDatabaseImpl.Utility.getDatabaseFile(parameter), CreateDatabaseImpl.Utility.getDatabaseName(parameter), CreateDatabaseImplContext.TaskRunnerContext.class);
            }
        }
    }

    public class SQLReader
    {
        public Object readXML(String bodhi, String dbname, Class<?> klass)
        {
            return null;
        }
    }
}
