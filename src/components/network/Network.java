package components.network;

import components.Component;
import exceptions.ExceptionQueue;
import structures.Queue;
import structures.SQLString;

public class Network extends Component
{
    public static Network reference;

    public ThreadImplementation thread = new ThreadImplementation();

    public Network() throws Exception
    {
        Network.reference = this;
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
