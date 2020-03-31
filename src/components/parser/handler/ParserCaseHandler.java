package components.parser.handler;

import cases.*;
import exceptions.ExceptionQueue;
import structures.Queue;
import structures.SQLString;

public class ParserCaseHandler
{
    public ParserCaseHandler.Unknown unknown;

    public ParserCaseHandler(Queue<SQLString> queue)
    {
         String sqlstring = queue.dequeue().value;

        try
        {
            if (sqlstring.startsWith("CREATE DATABASE"))
            {
                new ParserCaseHandler.CreateDatabase(sqlstring);
            }
            else if (sqlstring.startsWith("CREATE INDEX"))
            {
                new ParserCaseHandler.CreateIndex(sqlstring);
            }
            else if (sqlstring.startsWith("CREATE TABLE"))
            {
                new ParserCaseHandler.CreateTable(sqlstring);
            }
            else if (sqlstring.startsWith("DELETE FROM"))
            {
                new ParserCaseHandler.DeleteFrom(sqlstring);
            }
            else if (sqlstring.startsWith("DROP COLUMN"))
            {
                new ParserCaseHandler.DropColumn(sqlstring);
            }
            else if (sqlstring.startsWith("DROP DATABASE"))
            {
                new ParserCaseHandler.DropDatabase(sqlstring);
            }
            else if (sqlstring.startsWith("INSERT INTO"))
            {
                new ParserCaseHandler.InsertInto(sqlstring);
            }
            else if (sqlstring.startsWith("SELECT"))
            {
                new ParserCaseHandler.Select(sqlstring);
            }
            else if (sqlstring.startsWith("USE"))
            {
                new ParserCaseHandler.Use(sqlstring);
            }
            else if (sqlstring.startsWith("UPDATE"))
            {
                new ParserCaseHandler.Update(sqlstring);
            }
            else
            {
                throw new Exception("Unknown Case");
            }
        }
        catch (Exception e)
        {
            new ParserCaseHandler.Unknown();
        }
    }

    //

    public static class CreateDatabase extends UseCase
    {
        public CreateDatabase(String sqlstring) throws Exception
        {
            try
            {
                CreateDatabaseImpl runner = new CreateDatabaseImpl(sqlstring);
            }
            catch (Exception e)
            {
                ExceptionQueue equeue;

                equeue = new ExceptionQueue();

                equeue.enqueue(e, e.getMessage());
            }
        }
    }

    public static class CreateIndex extends UseCase
    {
        public CreateIndex(String sqlstring) throws Exception
        {
            try
            {
                CreateIndexImpl runner = new CreateIndexImpl(sqlstring);
            }
            catch(Exception e)
            {
                ExceptionQueue equeue;

                equeue = new ExceptionQueue();

                equeue.enqueue(e, e.getMessage());
            }
        }
    }

    public static class CreateTable extends UseCase
    {
        public CreateTable(String sqlstring) throws Exception
        {
            try
            {
                CreateTableImpl runner = new CreateTableImpl(sqlstring);
            }
            catch(Exception e)
            {
                ExceptionQueue equeue;

                equeue = new ExceptionQueue();

                equeue.enqueue(e, e.getMessage());
            }
        }
    }

    public static class DeleteFrom extends UseCase
    {
        public DeleteFrom(String sqlstring) throws Exception
        {
            try
            {
                DeleteFromImpl runner = new DeleteFromImpl(sqlstring);
            }
            catch (Exception e)
            {
                ExceptionQueue equeue;

                equeue = new ExceptionQueue();

                equeue.enqueue(e, e.getMessage());
            }
        }
    }

    public static class DropColumn extends UseCase
    {
        public DropColumn(String sqlstring) throws Exception
        {
            try
            {
                DropColumnImpl runner = new DropColumnImpl(sqlstring);
            }
            catch (Exception e)
            {
                ExceptionQueue equeue;

                equeue = new ExceptionQueue();

                equeue.enqueue(e, e.getMessage());
            }
        }
    }

    public static class DropDatabase extends UseCase
    {
        public DropDatabase(String sqlstring) throws Exception
        {
            try
            {
                DropDatabaseImpl runner = new DropDatabaseImpl(sqlstring);
            }
            catch (Exception e)
            {
                ExceptionQueue equeue;

                equeue = new ExceptionQueue();

                equeue.enqueue(e, e.getMessage());
            }
        }
    }

    public static class InsertInto extends UseCase
    {
        public InsertInto(String sqlstring)
        {
            try
            {
                InsertIntoTableImpl runner = new InsertIntoTableImpl(sqlstring);
            }
            catch (Exception e)
            {
                ExceptionQueue equeue;

                equeue = new ExceptionQueue();

                equeue.enqueue(e, e.getMessage());
            }
        }
    }

    public static class Select extends UseCase
    {
        public Select(String sqlstring)
        {
            try
            {
                SelectFromTableImpl runner = new SelectFromTableImpl(sqlstring); 
            }
            catch (Exception e)
            {
                ExceptionQueue equeue;

                equeue = new ExceptionQueue();

                equeue.enqueue(e, e.getMessage());
            }
        }
    }

    public static class Update extends UseCase
    {
        public Update(String sqlstring)
        {
            try
            {
                UpdateTableImpl runner = new UpdateTableImpl(sqlstring);
            }
            catch (Exception e)
            {
                ExceptionQueue equeue;

                equeue = new ExceptionQueue();

                equeue.enqueue(e, e.getMessage());            }
        }
    }

    public static class Use extends UseCase
    {
        public Use(String sqlstring)
        {
            try
            {
                UseDatabaseImpl runner = new UseDatabaseImpl(sqlstring);
            }
            catch(Exception e)
            {
                ExceptionQueue equeue;

                equeue = new ExceptionQueue();

                equeue.enqueue(e, e.getMessage());            }
        }
    }

    public static class Unknown extends UseCase
    {

    }
}