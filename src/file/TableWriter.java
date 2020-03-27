package file;

import parameter.Parameter;
import structures.table.Table;

public class TableWriter
{
    public Table table;

    public TableWriter(Table table)
    {
        this.table = table;
    }

    public void write()
    {
        DatabaseWriter writer = new DatabaseWriter(null);


    }
}
