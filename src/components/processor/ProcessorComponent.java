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

    public ProcessorComponent()
    {
        System.push("//processor", this);

        System.push("//processor/queue", this.queue);

        System.push("//processor/thread", this.thread);
    }

    public static class ThreadImplementation extends Thread
    {
        public Boolean running = true;

        @Override
        public void run()
        {
            LinkedList<SQLString> queue_in = (LinkedList<SQLString>)System.pull("//processor/queue");

            while (running)
            {
                try
                {
                    if(queue_in.peek()==null)
                    {
                        Thread.sleep(25,0); continue;
                    }

                    SQLString sql_string = queue_in.element();

                    //

                    //TODO statement type; do 16 cases then dump
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public void set(String bodhi, Parameter parameter, Class<?> klass)
    {

    }
}
