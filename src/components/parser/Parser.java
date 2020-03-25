package components.parser;

import components.Component;
import components.processor.builder.CaseHandler;
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
            Queue<SQLString> queue = (Queue<SQLString>)System.Memory.reference.pull("//parser/queue");

            while (running)
            {
                try
                {
                    if(queue.peek()==null) { Thread.sleep(25,0); continue; }

                    //

                    String sql_string = queue.element().value.toUpperCase();

                    //

                    CaseHandler handler = new CaseHandler();

                    //

                    if(sql_string.startsWith("CREATE DATABASE"))
                    {
                        handler.create_database = new CaseHandler.CreateDatabase();
                    }
                    else if(sql_string.startsWith("CREATE INDEX"))
                    {
                        handler.create_index = new CaseHandler.CreateIndex();
                    }
                    else if(sql_string.startsWith("CREATE TABLE"))
                    {
                        handler.create_table = new CaseHandler.CreateTable();
                    }
                    else if(sql_string.startsWith("DELETE FROM"))
                    {
                        handler.delete_from = new CaseHandler.DeleteFrom();
                    }
                    else if(sql_string.startsWith("DROP COLUMN"))
                    {
                        handler.drop_column = new CaseHandler.DropColumn();
                    }
                    else if(sql_string.startsWith("DROP DATABASE"))
                    {
                        handler.drop_database = new CaseHandler.DropDatabase();
                    }
                    else if(sql_string.startsWith("INSERT INTO"))
                    {
                        handler.insert_into = new CaseHandler.InsertInto();
                    }
                    else if(sql_string.startsWith("SELECT"))
                    {
                        handler.select = new CaseHandler.Select();
                    }
                    else if(sql_string.startsWith("UPDATE"))
                    {
                        handler.update = new CaseHandler.Update();
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

