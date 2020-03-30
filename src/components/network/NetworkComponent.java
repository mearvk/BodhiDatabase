package components.network;

import components.Component;
import exceptions.ExceptionQueue;
import structures.Queue;
import structures.SQLString;

public class NetworkComponent extends Component
{
    public static NetworkComponent reference;

    public ThreadImplementation thread = new ThreadImplementation();

    public NetworkComponent() throws Exception
    {
        NetworkComponent.reference = this;
    }

    public static class ThreadImplementation extends Thread
    {
        public Boolean running = true;

        public Queue<SQLString> queue = new Queue<SQLString>();

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
                         e.addSuppressed(e);
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
