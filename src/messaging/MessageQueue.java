package messaging;

import structures.Queue;
import structures.SQLString;

public class MessageQueue extends java.lang.Exception
{
    public static MessageQueue reference = new MessageQueue();

    public Queue<String> queue = new Queue<>();

    public MessageQueue()
    {
        MessageQueue.reference = this;
    }

    public void enqueue(Exception e)
    {
        this.queue.enqueue(e.getMessage());
    }

    public void enqueue(Exception e, String message)
    {
        this.queue.enqueue(message);
    }

    public void enqueue(StringBuffer message)
    {
        System.out.println(message);
    }

    public void enqueue(String message)
    {
        System.out.println(message);
    }

    public static class Thread extends java.lang.Thread
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
                            Thread.sleep(20, 0);

                            continue;
                        }
                        else
                        {
                            String message = this.queue.dequeue().value;

                            System.out.println(message);
                        }
                    }
                    catch (Exception e)
                    {
                        exceptions.ExceptionQueue queue;

                        queue = new exceptions.ExceptionQueue();

                        queue.enqueue(e, e.getMessage());
                    }
                }
            }
            catch (Exception e)
            {
                exceptions.ExceptionQueue queue;

                queue = new exceptions.ExceptionQueue();

                queue.enqueue(e, e.getMessage());
            }
        }
    }
}
