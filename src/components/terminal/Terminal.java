package components.terminal;

import components.Component;
import structures.SQLString;
import system.System;

import java.util.LinkedList;
import java.util.Queue;

public class Terminal extends Component
{
    public ThreadImplementation thread = new ThreadImplementation();

    public LinkedList<SQLString> queue = new LinkedList<SQLString>();

    public Terminal()
    {
        System.Memory.reference.push("//terminal", this);

        System.Memory.reference.push("//terminal/queue", this.queue);

        System.Memory.reference.push("//terminal/thread", this.thread);
    }

    public static class ThreadImplementation extends Thread
    {
        public Boolean running = true;

        @Override
        public void run()
        {
            LinkedList<SQLString> queue = (LinkedList<SQLString>)System.Memory.reference.pull("//terminal/queue");

            while (running)
            {
                try
                {
                    if(queue.peek()==null) {  Thread.sleep(25,0); continue; };

                    SQLString sqlString = queue.element();



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
