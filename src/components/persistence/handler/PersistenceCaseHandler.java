package components.persistence.handler;

import cases.*;
import structures.Queue;
import structures.SQLString;

public class PersistenceCaseHandler
{
    public PersistenceCaseHandler.CreateDatabase create_database;

    public PersistenceCaseHandler.CreateIndex create_index;

    public PersistenceCaseHandler.CreateTable create_table;

    public PersistenceCaseHandler.DeleteFrom delete_from;

    public PersistenceCaseHandler.DropColumn drop_column;

    public PersistenceCaseHandler.DropDatabase drop_database;

    public PersistenceCaseHandler.InsertInto insert_into;

    public PersistenceCaseHandler.Select select;

    public PersistenceCaseHandler.Update update;

    public PersistenceCaseHandler.Use use;

    public PersistenceCaseHandler.Unknown unknown;

    //

    public PersistenceCaseHandler(Queue<SQLString> queue)
    {
        String sqlString = queue.poll().value.toUpperCase();

        try
        {
            if (sqlString.startsWith("CREATE DATABASE"))
            {
                this.create_database = new PersistenceCaseHandler.CreateDatabase(sqlString);
            }
            else if (sqlString.startsWith("CREATE INDEX"))
            {
                this.create_index = new PersistenceCaseHandler.CreateIndex(sqlString);
            }
            else if (sqlString.startsWith("CREATE TABLE"))
            {
                this.create_table = new PersistenceCaseHandler.CreateTable(sqlString);
            }
            else if (sqlString.startsWith("DELETE FROM"))
            {
                this.delete_from = new PersistenceCaseHandler.DeleteFrom(sqlString);
            }
            else if (sqlString.startsWith("DROP COLUMN"))
            {
                this.drop_column = new PersistenceCaseHandler.DropColumn(sqlString);
            }
            else if (sqlString.startsWith("DROP DATABASE"))
            {
                this.drop_database = new PersistenceCaseHandler.DropDatabase(sqlString);
            }
            else if (sqlString.startsWith("INSERT INTO"))
            {
                this.insert_into = new PersistenceCaseHandler.InsertInto(sqlString);
            }
            else if (sqlString.startsWith("SELECT"))
            {
                this.select = new PersistenceCaseHandler.Select(sqlString);
            }
            else if (sqlString.startsWith("USE"))
            {
                this.use = new PersistenceCaseHandler.Use(sqlString);
            }
            else if (sqlString.startsWith("UPDATE"))
            {
                this.update = new PersistenceCaseHandler.Update(sqlString);
            }
            else
            {
                throw new Exception("Unknown Case");
            }
        }
        catch (Exception e)
        {

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
