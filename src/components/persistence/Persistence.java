package components.persistence;

import components.Component;
import components.persistence.handler.PersistenceCaseHandler;
import contexts.CreateDatabaseImplContext;
import exceptions.ExceptionQueue;
import parameter.Parameter;
import structures.Queue;
import structures.SQLString;
import system.System;

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
            this.writer.writeJson(bodhi, parameter, klass);
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
}
