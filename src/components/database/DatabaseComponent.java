package components.database;

import components.Component;
import structures.SQLString;
import parameter.Parameter;
import structures.database.DatabaseReference;
import structures.table.Table;

import java.util.LinkedList;

public class DatabaseComponent extends Component
{
    public DatabaseReference.Reference reference;

    public Table last_table;

    public Table current_table;

    public ThreadImplementation thread = new ThreadImplementation();

    public LinkedList<SQLString> queue = new LinkedList<SQLString>();

    public DatabaseComponent()
    {

    }

    public DatabaseComponent(Parameter parameter)
    {

    }

    public DatabaseComponent(String bodhi)
    {

    }

    public static class ThreadImplementation extends Thread
    {
        public Boolean running = true;

        @Override
        public void run()
        {

        }
    }
}
