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

import java.io.*;

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

    public void write(String bodhi, Parameter parameter, Class<?> klass)
    {
        if(bodhi.equals("//database") && klass.isAssignableFrom(CreateDatabaseImplContext.TaskRunnerContext.class))
        {
            this.writer.writeJson(bodhi, CreateDatabaseImpl.Utility.getDatabaseName(parameter), klass);
        }
    }

    public void read(String bodhi, Parameter parameter, Class<?> klass)
    {
        if(bodhi.equals("//database") && klass.isAssignableFrom(CreateDatabaseImplContext.TaskRunnerContext.class))
        {
            this.reader.readJson(bodhi, CreateDatabaseImpl.Utility.getDatabaseName(parameter), klass);
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
        public void writeJson(String bodhi, String dbname, Class<?> context)
        {
            try
            {
                JSONObject db = new JSONObject();

                db.put("type", "database");

                db.put("name", dbname+".sql");

                db.put("version", "1.0");

                //

                //JSONObject dbobject = new JSONObject();

                //dbobject.put(dbname, db);

                //

                //JSONArray dblist = new JSONArray();

                //dblist.put(dbobject);

                //

                FileWriter filewriter = new FileWriter(DatabaseConstants.baseURL+"\\"+dbname+".sql");

                filewriter.write(db.toString());

                filewriter.flush();

                filewriter.close();

                filewriter = null;
            }
            catch (Exception e)
            {
                ExceptionQueue equeue;

                equeue = new ExceptionQueue();

                equeue.enqueue(e, e.getMessage());
            }
        }
    }

    public class SQLReader
    {
        public JSONObject readJson(String bodhi, String dbname, Class<?> klass)
        {
            if(bodhi.equals("//database") && klass.isAssignableFrom(CreateDatabaseImplContext.TaskRunnerContext.class))
            {
                try
                {
                    Utility.JSONReader reader;

                    reader = new Utility.JSONReader(new BufferedReader(new FileReader(DatabaseConstants.baseURL+"\\"+dbname+".sql")));

                    return new JSONObject(reader.buffer.toString());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            return null;
        }
    }
}
