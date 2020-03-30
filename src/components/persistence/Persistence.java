package components.persistence;

import components.Component;
import components.persistence.handler.PersistenceCaseHandler;
import exceptions.ExceptionQueue;
import structures.Queue;
import structures.SQLString;
import system.System;

public class Persistence extends Component
{
    public Thread thread = new Thread();

    public Queue<SQLString> queue = new Queue<SQLString>();

    public Persistence() throws Exception
    {
        System.push("//persistence", this);
    }

    public static class Thread extends java.lang.Thread
    {
        public Queue<SQLString> queue = new Queue<SQLString>();

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
                            java.lang.Thread.sleep(20, 0);

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
