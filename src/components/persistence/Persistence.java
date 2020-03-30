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
                ExceptionQueue.enqueue(e.getMessage());
            }
        }
    }
}
