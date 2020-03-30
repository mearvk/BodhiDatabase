package components.processor;

import components.Component;
import components.parser.ParserComponent;
import parameter.Parameter;
import structures.SQLString;
import system.System;

import java.util.LinkedList;

public class ProcessorComponent extends Component
{
    public static ProcessorComponent reference;

    public ThreadImplementation thread= new ThreadImplementation();

    public ProcessorComponent() throws Exception
    {
        ProcessorComponent.reference = this;
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
