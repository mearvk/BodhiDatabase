package components.parser.thread;

import components.parser.handler.ParserCaseHandler;
import exceptions.ExceptionQueue;
import structures.SQLString;
import system.System;

import java.util.LinkedList;

public class ParserThread extends Thread
{
    public Boolean running = true;

    @Override
    public void run()
    {
        LinkedList<SQLString> queue = null;

        try
        {
            queue = (LinkedList<SQLString>) System.pull("//parser/queue");

            while (running)
            {
                try
                {
                    if (queue.peek() == null)
                    {
                        Thread.sleep(20, 0);

                        continue;
                    }

                    ParserCaseHandler handler = new ParserCaseHandler(queue);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e)
        {
            ExceptionQueue.push(e.getMessage());
        }
    }
}