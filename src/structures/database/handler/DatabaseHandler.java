package structures.database.handler;

import file.DatabaseReader;
import file.DatabaseWriter;
import structures.database.Database;
import system.System;

public class DatabaseHandler
{
    public DatabaseWriter writer;

    public DatabaseReader reader;

    public DatabaseHandler()
    {
        Database database = (Database)System.Memory.reference.pull("//database");

        this.writer = new DatabaseWriter(database);

        this.reader = new DatabaseReader(database);
    }

    protected boolean integrity()
    {
        //TODO reader checks integrity

        return true;
    }

    public DatabaseHandler write_table()
    {
        return this;
    }
}
