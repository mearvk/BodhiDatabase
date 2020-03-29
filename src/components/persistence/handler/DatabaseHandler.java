package components.persistence.handler;

import file.DatabaseReader;
import file.DatabaseWriter;
import parameter.Parameter;
import structures.database.DatabaseReference;
import system.System;

public class DatabaseHandler
{
    public DatabaseWriter writer;

    public DatabaseReader reader;

    public DatabaseHandler(Parameter parameter)
    {
        DatabaseReference database = (DatabaseReference)System.pull("//database");

        this.writer = new DatabaseWriter(database);

        this.reader = new DatabaseReader(database);
    }

    protected boolean integrity()
    {
        //TODO reader checks integrity

        return true;
    }

    public DatabaseHandler createTable()
    {
        return this;
    }
}
