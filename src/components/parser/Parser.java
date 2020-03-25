package components.parser;

import components.Component;
import structures.SQLString;
import system.System;

import java.util.LinkedList;
import java.util.Queue;

public class Parser extends Component
{
    public ThreadImplementation_001 thread = new ThreadImplementation_001();

    public Queue<SQLString> queue_in = new LinkedList();

    public Queue<SQLString> queue_out = new LinkedList();

    public Parser()
    {
        System.Memory.reference.push("//parser", this);

        System.Memory.reference.push("//parser/queue/in", this.queue_in);

        System.Memory.reference.push("//parser/queue/out", this.queue_out);

        System.Memory.reference.push("//parser/thread", this.thread);
    }

    public static class ThreadImplementation_001 extends Thread
    {
        public Boolean running = true;

        @Override
        public void run()
        {
            Queue<SQLString> queue_in = (Queue<SQLString>)System.Memory.reference.pull("//parser/queues/in");

            Queue<SQLString> queue_out = (Queue<SQLString>)System.Memory.reference.pull("//parser/queues/out");

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

                     //

                     queue_out.add(sql_string);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
        }
    }
}

