package components.processor.builder;

import components.cases.Case;
import structures.SQLString;

import java.util.LinkedList;

public class ParserCaseHandler
{
    public CreateDatabase create_database;

    public CreateIndex create_index;

    public CreateTable create_table;

    public DeleteFrom delete_from;

    public DropColumn drop_column;

    public DropDatabase drop_database;

    public InsertInto insert_into;

    public Select select;

    public Update update;

    //

    public ParserCaseHandler(LinkedList<SQLString> queue)
    {
        String sqlString = queue.element().value.trim().toUpperCase();

        if(sqlString.startsWith("CREATE DATABASE"))
        {
            this.create_database = new ParserCaseHandler.CreateDatabase();
        }
        else if(sqlString.startsWith("CREATE INDEX"))
        {
            this.create_index = new ParserCaseHandler.CreateIndex();
        }
        else if(sqlString.startsWith("CREATE TABLE"))
        {
            this.create_table = new ParserCaseHandler.CreateTable();
        }
        else if(sqlString.startsWith("DELETE FROM"))
        {
            this.delete_from = new ParserCaseHandler.DeleteFrom();
        }
        else if(sqlString.startsWith("DROP COLUMN"))
        {
            this.drop_column = new ParserCaseHandler.DropColumn();
        }
        else if(sqlString.startsWith("DROP DATABASE"))
        {
            this.drop_database = new ParserCaseHandler.DropDatabase();
        }
        else if(sqlString.startsWith("INSERT INTO"))
        {
            this.insert_into = new ParserCaseHandler.InsertInto();
        }
        else if(sqlString.startsWith("SELECT"))
        {
            this.select = new ParserCaseHandler.Select();
        }
        else if(sqlString.startsWith("UPDATE"))
        {
            this.update = new ParserCaseHandler.Update();
        }
    }

    //

    public static class CreateDatabase extends Case
    {

    }

    public static class CreateIndex extends Case
    {

    }

    public static class CreateTable extends Case
    {

    }

    public static class DeleteFrom extends Case
    {

    }

    public static class DropColumn extends Case
    {

    }

    public static class DropDatabase extends Case
    {

    }

    public static class InsertInto extends Case
    {

    }

    public static class Select extends Case
    {

    }

    public static class Update extends Case
    {

    }
}
