package components.database;

import components.Component;
import structures.SQLString;
import parameter.Parameter;
import structures.database.DatabaseReference;

import java.util.LinkedList;

public class Database extends Component
{
    public DatabaseReference.Reference reference;

    public ThreadImplementation thread = new ThreadImplementation();

    public LinkedList<SQLString> queue = new LinkedList<SQLString>();

    public Database()
    {

    }

    public Database(Parameter parameter)
    {

    }

    public Database(String bodhi)
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
