package components.parser;

import components.Component;
import components.processor.builder.ParserCaseHandler;
import structures.SQLString;
import system.System;

import java.util.LinkedList;

public class Parser extends Component
{
    public ThreadImplementation thread = new ThreadImplementation();

    public LinkedList<SQLString> queue = new LinkedList<SQLString>();

    public Parser()
    {
        System.Memory.reference.push("//parser", this);

        System.Memory.reference.push("//parser/queue", this.queue);

        System.Memory.reference.push("//parser/thread", this.thread);
    }

    public static class ThreadImplementation extends Thread
    {
        public Boolean running = true;

        @Override
        public void run()
        {
            LinkedList<SQLString> queue = (LinkedList<SQLString>)System.Memory.reference.pull("//parser/queue");

            while (running)
            {
                try
                {
                    if(queue.peek()==null) { Thread.sleep(20,0); continue; }

                    //

                    ParserCaseHandler handler = new ParserCaseHandler(queue);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}

