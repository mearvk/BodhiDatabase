package components.parser;

import components.Component;
import components.cases.*;
import structures.SQLString;
import system.System;

import java.util.LinkedList;

public class Parser extends Component
{
    public ThreadImplementation thread = new ThreadImplementation();

    public LinkedList<SQLString> queue = new LinkedList<>();

    public Parser()
    {
        System.Memory.reference.push("//parser", this);

        System.Memory.reference.push("//parser/queue", this.queue);

        System.Memory.reference.push("//parser/thread", this.thread);
    }

    public static class CaseHandler
    {
        public CaseHandler.CreateDatabase create_database;

        public CaseHandler.CreateIndex create_index;

        public CaseHandler.CreateTable create_table;

        public CaseHandler.DeleteFrom delete_from;

        public CaseHandler.DropColumn drop_column;

        public CaseHandler.DropDatabase drop_database;

        public CaseHandler.InsertInto insert_into;

        public CaseHandler.Select select;

        public CaseHandler.Update update;

        public CaseHandler.Unknown unknown;

        //

        public CaseHandler(LinkedList<SQLString> queue)
        {
            String sqlString = queue.element().value.toUpperCase();

            try
            {
                if (sqlString.startsWith("CREATE DATABASE"))
                {
                    this.create_database = new CaseHandler.CreateDatabase(sqlString);
                }
                else if (sqlString.startsWith("CREATE INDEX"))
                {
                    this.create_index = new CaseHandler.CreateIndex(sqlString);
                }
                else if (sqlString.startsWith("CREATE TABLE"))
                {
                    this.create_table = new CaseHandler.CreateTable(sqlString);
                }
                else if (sqlString.startsWith("DELETE FROM"))
                {
                    this.delete_from = new CaseHandler.DeleteFrom(sqlString);
                }
                else if (sqlString.startsWith("DROP COLUMN"))
                {
                    this.drop_column = new CaseHandler.DropColumn(sqlString);
                }
                else if (sqlString.startsWith("DROP DATABASE"))
                {
                    this.drop_database = new CaseHandler.DropDatabase(sqlString);
                }
                else if (sqlString.startsWith("INSERT INTO"))
                {
                    this.insert_into = new CaseHandler.InsertInto(sqlString);
                }
                else if (sqlString.startsWith("SELECT"))
                {
                    this.select = new CaseHandler.Select(sqlString);
                }
                else if (sqlString.startsWith("UPDATE"))
                {
                    this.update = new CaseHandler.Update(sqlString);
                }
                else
                {
                    throw new Exception("Unknown Case");
                }
            }
            catch (Exception e)
            {
                this.unknown = new CaseHandler.Unknown();
            }
        }

        //

        public static class CreateDatabase extends Case
        {
            public String sqlString;

            public CreateDatabase(String sqlString)
            {
                CreateDatabaseImpl runner = new CreateDatabaseImpl(this.sqlString = sqlString);
            }
        }

        public static class CreateIndex extends Case
        {
            public String sqlString;

            public CreateIndex(String sqlString)
            {
                CreateIndexImpl runner = new CreateIndexImpl(this.sqlString = sqlString);
            }
        }

        public static class CreateTable extends Case
        {
            public String sqlString;

            public CreateTable(String sqlString)
            {
                CreateTableImpl runner = new CreateTableImpl(this.sqlString = sqlString);

                this.sqlString = sqlString;
            }
        }

        public static class DeleteFrom extends Case
        {
            public String sqlString;

            public DeleteFrom(String sqlString)
            {
                DeleteFrom runner = new DeleteFrom(this.sqlString = sqlString);
            }
        }

        public static class DropColumn extends Case
        {
            public String sqlString;

            public DropColumn(String sqlString)
            {
                DropColumnImpl runner = new DropColumnImpl(this.sqlString = sqlString);
            }
        }

        public static class DropDatabase extends Case
        {
            public String sqlString;

            public DropDatabase(String sqlString)
            {
                DropDatabaseImpl runner = new DropDatabaseImpl(this.sqlString = sqlString);
            }
        }

        public static class InsertInto extends Case
        {
            public String sqlString;

            public InsertInto(String sqlString)
            {
                InsertIntoImpl runner = new InsertIntoImpl(this.sqlString = sqlString);
            }
        }

        public static class Select extends Case
        {
            public String sqlString;

            public Select(String sqlString)
            {
                SelectImpl runner = new SelectImpl(this.sqlString = sqlString);
            }
        }

        public static class Update extends Case
        {
            public String sqlString;

            public Update(String sqlString)
            {
                UpdateImpl runner = new UpdateImpl(this.sqlString = sqlString);
            }
        }

        public static class Unknown extends Case
        {

        }
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
                    if(queue.peek()==null)
                    {
                        Thread.sleep(20,0);

                        continue;
                    }

                    CaseHandler handler = new CaseHandler(queue);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}

