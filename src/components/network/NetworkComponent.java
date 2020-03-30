package components.network;

import components.Component;
import exceptions.ExceptionQueue;
import structures.SQLString;
import system.System;

import java.util.LinkedList;

public class NetworkComponent extends Component
{
    public ThreadImplementation thread = new ThreadImplementation();

    public NetworkComponent() throws Exception
    {
        System.push("//network", this);
    }

    public static class ThreadImplementation extends Thread
    {
        public Boolean running = true;

        public LinkedList<SQLString> queue = new LinkedList<SQLString>();

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
                            Thread.sleep(25, 0);

                            continue;
                        }
                    }
                    catch (Exception e)
                    {
                        ExceptionQueue.enqueue(e);
                    }
                }
            }
            catch (Exception e)
            {
                ExceptionQueue.enqueue(e);
            }
        }
    }
}
