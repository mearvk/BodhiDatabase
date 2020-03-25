package components.parser.handler;

import components.cases.*;
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

    public ParserCaseHandler.Unknown unknown;

    //

    public ParserCaseHandler(LinkedList<SQLString> queue)
    {
        String sqlString = queue.poll().value.toUpperCase();

        try
        {
            if (sqlString.startsWith("CREATE DATABASE"))
            {
                this.create_database = new ParserCaseHandler.CreateDatabase(sqlString);
            }
            else if (sqlString.startsWith("CREATE INDEX"))
            {
                this.create_index = new ParserCaseHandler.CreateIndex(sqlString);
            }
            else if (sqlString.startsWith("CREATE TABLE"))
            {
                this.create_table = new ParserCaseHandler.CreateTable(sqlString);
            }
            else if (sqlString.startsWith("DELETE FROM"))
            {
                this.delete_from = new ParserCaseHandler.DeleteFrom(sqlString);
            }
            else if (sqlString.startsWith("DROP COLUMN"))
            {
                this.drop_column = new ParserCaseHandler.DropColumn(sqlString);
            }
            else if (sqlString.startsWith("DROP DATABASE"))
            {
                this.drop_database = new ParserCaseHandler.DropDatabase(sqlString);
            }
            else if (sqlString.startsWith("INSERT INTO"))
            {
                this.insert_into = new ParserCaseHandler.InsertInto(sqlString);
            }
            else if (sqlString.startsWith("SELECT"))
            {
                this.select = new ParserCaseHandler.Select(sqlString);
            }
            else if (sqlString.startsWith("UPDATE"))
            {
                this.update = new ParserCaseHandler.Update(sqlString);
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