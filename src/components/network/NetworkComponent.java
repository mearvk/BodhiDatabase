package components.network;

import components.Component;
import structures.SQLString;
import system.System;

import java.util.LinkedList;

public class NetworkComponent extends Component
{
    public ThreadImplementation thread = new ThreadImplementation();

    public LinkedList<SQLString> queue = new LinkedList<SQLString>();

    public NetworkComponent()
    {
        System.push("//network", this);

        System.push("//network/queue", this.queue);

        System.push("//network/thread", this.thread);
    }

    public static class ThreadImplementation extends Thread
    {
        public Boolean running = true;

        @Override
        public void run()
        {
            LinkedList<SQLString> queue_in = (LinkedList<SQLString>)System.pull("//network/queue");

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
