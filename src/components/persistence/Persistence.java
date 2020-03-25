package components.persistence;

import components.Component;
import structures.SQLString;
import system.System;

import java.util.Queue;

public class Persistence extends Component
{
    public ThreadImplementation thread = new ThreadImplementation();

    public Persistence()
    {
        System.Memory.reference.push("//persistence", this);

        System.Memory.reference.push("//persistence/queue", this);

        System.Memory.reference.push("//persistence/thread", this.thread);
    }

    public static class ThreadImplementation extends Thread
    {
        public Boolean running = true;

        @Override
        public void run()
        {
            Queue<SQLString> queue_in = (Queue<SQLString>)System.Memory.reference.pull("//persistence/queue");

            while (running)
            {
                try
                {
                    if(queue_in.peek()==null)
                    {
                        Thread.sleep(25,0); continue;
                    }

                    String sqlString = queue_in.element().value;

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
