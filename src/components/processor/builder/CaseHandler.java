package components.processor.builder;

import components.cases.Case;

public class CaseHandler
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
