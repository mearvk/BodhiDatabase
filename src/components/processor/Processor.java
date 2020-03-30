package components.processor;

import components.Component;
import parameter.Parameter;
import structures.SQLString;

import java.util.LinkedList;

public class Processor extends Component
{
    public static Processor reference;

    public Thread thread= new Thread();

    public Processor() throws Exception
    {
        Processor.reference = this;
    }

    public static class Thread extends java.lang.Thread
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
                            java.lang.Thread.sleep(25, 0);

                            continue;
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            catch (Exception e)
            {

            }
        }
    }

    public void set(String bodhi, Parameter parameter, Class<?> klass)
    {

    }
}
