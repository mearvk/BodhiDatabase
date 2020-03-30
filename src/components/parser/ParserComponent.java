package components.parser;

import components.Component;
import components.parser.handler.ParserCaseHandler;
import exceptions.ExceptionQueue;
import structures.Queue;
import structures.SQLString;

public class ParserComponent extends Component
{
    public static ParserComponent reference;

    public ParserThread thread = new ParserThread();

    public ParserComponent() throws Exception
    {
        ParserComponent.reference = this;
    }

    public static class ParserThread extends Thread
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

                        ParserCaseHandler handler = new ParserCaseHandler(this.queue);
                    }
                    catch (Exception e)
                    {
                        ExceptionQueue.enqueue(e);
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

