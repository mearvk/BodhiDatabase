package components.processor;

import components.Component;
import structures.SQLString;
import system.System;

import java.util.Queue;

public class Processor extends Component
{
    public Processor.ThreadImplementation_001 thread= new ThreadImplementation_001();

    public Processor()
    {
        System.Memory.reference.push("//processor", this);

        System.Memory.reference.push("//processor/queue", this);

        System.Memory.reference.push("//processor/thread", this.thread);
    }

    public static class ThreadImplementation_001 extends Thread
    {
        public Boolean running = true;

        @Override
        public void run()
        {
            Queue<SQLString> queue_in = (Queue<SQLString>)System.Memory.reference.pull("//processor/queue");

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
}
