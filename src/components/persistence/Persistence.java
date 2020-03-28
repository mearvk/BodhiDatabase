package components.persistence;

import components.Component;
import components.parser.handler.ParserCaseHandler;
import components.persistence.handler.PersistenceCaseHandler;
import javafx.util.converter.PercentageStringConverter;
import structures.Queue;
import structures.SQLString;
import system.System;

import java.util.LinkedList;

public class Persistence extends Component
{
    public PersistenceCaseHandler.CreateDatabase create_database;

    public ThreadImplementation thread = new ThreadImplementation();

    public Queue<SQLString> queue = new Queue<SQLString>();

    public Persistence()
    {
        System.Memory.reference.push("//persistence", this);

        System.Memory.reference.push("//persistence/queue", this.queue);

        System.Memory.reference.push("//persistence/thread", this.thread);
    }

    public static class ThreadImplementation extends Thread
    {
        public Boolean running = true;

        @Override
        public void run()
        {
            Queue<SQLString> queue = (Queue<SQLString>)System.Memory.reference.pull("//persistence/queue");

            while (running)
            {
                try
                {
                    if(queue.peek()==null)
                    {
                        Thread.sleep(20 ,0); continue;
                    }

                    PersistenceCaseHandler handler = new PersistenceCaseHandler(queue);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
