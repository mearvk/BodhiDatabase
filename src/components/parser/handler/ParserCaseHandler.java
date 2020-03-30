package components.parser.handler;

import cases.*;
import structures.SQLString;

import java.util.LinkedList;

public class ParserCaseHandler
{
    public ParserCaseHandler.CreateDatabase create_database;

    public ParserCaseHandler.CreateIndex create_index;

    public ParserCaseHandler.CreateTable create_table;

    public ParserCaseHandler.DeleteFrom delete_from;

    public ParserCaseHandler.DropColumn drop_column;

    public ParserCaseHandler.DropDatabase drop_database;

    public ParserCaseHandler.InsertInto insert_into;

    public ParserCaseHandler.Select select;

    public ParserCaseHandler.Update update;

    public ParserCaseHandler.Use use;

    public ParserCaseHandler.Unknown unknown;

    //

    public ParserCaseHandler(LinkedList<SQLString> queue)
    {
        String sqlstring = queue.poll().value.toUpperCase();

        try
        {
            if (sqlstring.startsWith("CREATE DATABASE"))
            {
                this.create_database = new ParserCaseHandler.CreateDatabase(sqlstring);
            }
            else if (sqlstring.startsWith("CREATE INDEX"))
            {
                this.create_index = new ParserCaseHandler.CreateIndex(sqlstring);
            }
            else if (sqlstring.startsWith("CREATE TABLE"))
            {
                this.create_table = new ParserCaseHandler.CreateTable(sqlstring);
            }
            else if (sqlstring.startsWith("DELETE FROM"))
            {
                this.delete_from = new ParserCaseHandler.DeleteFrom(sqlstring);
            }
            else if (sqlstring.startsWith("DROP COLUMN"))
            {
                this.drop_column = new ParserCaseHandler.DropColumn(sqlstring);
            }
            else if (sqlstring.startsWith("DROP DATABASE"))
            {
                this.drop_database = new ParserCaseHandler.DropDatabase(sqlstring);
            }
            else if (sqlstring.startsWith("INSERT INTO"))
            {
                this.insert_into = new ParserCaseHandler.InsertInto(sqlstring);
            }
            else if (sqlstring.startsWith("SELECT"))
            {
                this.select = new ParserCaseHandler.Select(sqlstring);
            }
            else if (sqlstring.startsWith("USE"))
            {
                this.use = new ParserCaseHandler.Use(sqlstring);
            }
            else if (sqlstring.startsWith("UPDATE"))
            {
                this.update = new ParserCaseHandler.Update(sqlstring);
            }
            else
            {
                throw new Exception("Unknown Case");
            }
        }
        catch (Exception e)
        {
            this.unknown = new ParserCaseHandler.Unknown();
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