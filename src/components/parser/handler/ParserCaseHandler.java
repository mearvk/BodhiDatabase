package components.parser.handler;

import cases.*;
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
        public String sqlString;

        public CreateDatabase(String sqlString) throws Exception
        {
            try
            { CreateDatabaseImpl runner = new CreateDatabaseImpl(this.sqlString = sqlString); }
            catch (Exception e)
            {
                //TODO
            }
        }
    }

    public static class CreateIndex extends UseCase
    {
        public String sqlString;

        public CreateIndex(String sqlString) throws Exception
        {
            try
            { CreateIndexImpl runner = new CreateIndexImpl(this.sqlString = sqlString); }
            catch(Exception e)
            {

            }
        }
    }

    public static class CreateTable extends UseCase
    {
        public String sqlString;

        public CreateTable(String sqlString) throws Exception
        {
            try
            { CreateTableImpl runner = new CreateTableImpl(this.sqlString = sqlString); }
            catch(Exception e)
            {
                //TODO
            }

            this.sqlString = sqlString;
        }
    }

    public static class DeleteFrom extends UseCase
    {
        public String sqlString;

        public DeleteFrom(String sqlString) throws Exception
        {
            try
            { DeleteFromImpl runner = new DeleteFromImpl(this.sqlString = sqlString); }
            catch (Exception e)
            {
                //TODO
            }
        }
    }

    public static class DropColumn extends UseCase
    {
        public String sqlString;

        public DropColumn(String sqlString) throws Exception
        {
            try
            { DropColumnImpl runner = new DropColumnImpl(this.sqlString = sqlString); }
            catch (Exception e)
            {
                //TODO
            }
        }
    }

    public static class DropDatabase extends UseCase
    {
        public String sqlString;

        public DropDatabase(String sqlString) throws Exception
        {
            try
            { DropDatabaseImpl runner = new DropDatabaseImpl(this.sqlString = sqlString); }
            catch (Exception e)
            {
                //TODO
            }
        }
    }

    public static class InsertInto extends UseCase
    {
        public String sqlString;

        public InsertInto(String sqlString)
        {
            try
            { InsertIntoTableImpl runner = new InsertIntoTableImpl(this.sqlString = sqlString); }
            catch (Exception e)
            {
                //TODO
            }
        }
    }

    public static class Select extends UseCase
    {
        public String sqlString;

        public Select(String sqlString)
        {
            try
            { SelectFromTableImpl runner = new SelectFromTableImpl(this.sqlString = sqlString); }
            catch (Exception e)
            {

            }
        }
    }

    public static class Update extends UseCase
    {
        public String sqlString;

        public Update(String sqlString)
        {
            try
            { UpdateTableImpl runner = new UpdateTableImpl(this.sqlString = sqlString); }
            catch (Exception e)
            {
                //TODO
            }
        }
    }

    public static class Use extends UseCase
    {
        public String sqlString;

        public Use(String sqlString)
        {
            try
            { UseDatabaseImpl runner = new UseDatabaseImpl(this.sqlString = sqlString); }
            catch(Exception e)
            {
                //TODO
            }
        }
    }

    public static class Unknown extends UseCase
    {

    }
}