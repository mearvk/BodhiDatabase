package components.parser;

import components.Component;
import structures.SQLString;
import system.System;

import java.util.LinkedList;
import java.util.Queue;

public class Parser extends Component
{
    public ThreadImplementation thread = new ThreadImplementation();

    public Queue<SQLString> queue_in = new LinkedList();

    public Parser()
    {
        System.Memory.reference.push("//parser", this);

        System.Memory.reference.push("//parser/queue", this.queue_in);

        System.Memory.reference.push("//parser/thread", this.thread);
    }

    public static class ThreadImplementation extends Thread
    {
        public Boolean running = true;

        @Override
        public void run()
        {
            Queue<SQLString> queue_in = (Queue<SQLString>)System.Memory.reference.pull("//parser/queue");

            while (running)
            {
                try
                {
                    if(queue_in.peek()==null) { Thread.sleep(25,0); continue; }

                    //

                    String sqlString = queue_in.element().value;

                    //

                    if(sqlString.startsWith("CREATE TABLE"))
                    {

                    }
                    if(sqlString.startsWith("DELETE"))
                    {

                    }
                    else if(sqlString.startsWith("DROP"))
                    {

                    }
                    else if(sqlString.startsWith("INSERT INTO"))
                    {

                    }
                    else if(sqlString.startsWith("SELECT"))
                    {

                    }
                    else if(sqlString.startsWith("UPDATE"))
                    {

                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}

