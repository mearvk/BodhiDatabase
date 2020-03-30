package components.processor;

import components.Component;
import parameter.Parameter;
import structures.SQLString;
import system.System;

import java.util.LinkedList;

public class ProcessorComponent extends Component
{
    public ThreadImplementation thread= new ThreadImplementation();

    public LinkedList<SQLString> queue = new LinkedList<SQLString>();

    public ProcessorComponent() throws Exception
    {
        System.push("//processor", this);

        System.push("//processor/queue", this.queue);

        System.push("//processor/thread", this.thread);
    }

    public static class ThreadImplementation extends Thread
    {
        public Boolean running = true;

        public LinkedList<SQLString> queue = null;

        @Override
        public void run()
        {
            try
            {
                queue = (LinkedList<SQLString>) System.pull("//processor/queue");

                while (running) {
                    try {
                        if (queue.peek() == null) {
                            Thread.sleep(25, 0);
                            continue;
                        }

                        SQLString sql_string = queue.element();

                        //

                        //TODO statement type; do 16 cases then dump
                    } catch (Exception e) {
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
