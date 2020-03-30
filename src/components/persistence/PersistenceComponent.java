package components.persistence;

import components.Component;
import components.persistence.handler.PersistenceCaseHandler;
import exceptions.ExceptionQueue;
import structures.Queue;
import structures.SQLString;
import system.System;

public class PersistenceComponent extends Component
{
    public PersistenceCaseHandler.CreateDatabase create_database;

    public ThreadImplementation thread = new ThreadImplementation();

    public Queue<SQLString> queue = new Queue<SQLString>();

    public PersistenceComponent() throws Exception
    {
        System.push("//persistence", this);

        System.push("//persistence/queue", this.queue);

        System.push("//persistence/thread", this.thread);
    }

    public static class ThreadImplementation extends Thread
    {
        public Boolean running = true;

        @Override
        public void run()
        {
            Queue<SQLString> queue = null;

            try
            {
                queue = (Queue<SQLString>) System.pull("//persistence/queue");

                while (running)
                {
                    try
                    {
                        if (queue.peek() == null)
                        {
                            Thread.sleep(20, 0);

                            continue;
                        }

                        PersistenceCaseHandler handler = new PersistenceCaseHandler(queue);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            catch (Exception e)
            {
                ExceptionQueue.enqueue(e.getMessage());
            }
        }
    }
}
