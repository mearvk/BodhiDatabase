package components.parser;

import components.Component;
import components.parser.handler.ParserCaseHandler;
import exceptions.ExceptionQueue;
import structures.Queue;
import structures.SQLString;

public class Parser extends Component
{
    public static Parser reference;

    public ParserThread thread = new ParserThread();

    public Parser() throws Exception
    {
        Parser.reference = this;
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
                        else new ParserCaseHandler(this.queue);
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

