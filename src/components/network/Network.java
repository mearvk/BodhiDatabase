package components.network;

import components.Component;
import structures.SQLString;
import system.System;

import java.util.LinkedList;

public class Network extends Component
{
    public ThreadImplementation thread = new ThreadImplementation();

    public LinkedList<SQLString> queue = new LinkedList<SQLString>();

    public Network()
    {
        System.Memory.reference.push("//network", this);

        System.Memory.reference.push("//network/queue", this.queue);

        System.Memory.reference.push("//network/thread", this.thread);
    }

    public static class ThreadImplementation extends Thread
    {
        public Boolean running = true;

        @Override
        public void run()
        {
            LinkedList<SQLString> queue_in = (LinkedList<SQLString>)System.Memory.reference.pull("//network/queue");

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
