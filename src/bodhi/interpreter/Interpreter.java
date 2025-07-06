package bodhi.interpreter;

import bodhi.BodhiDatabase;
import bodhi.network.RemoteBodhiServer;
import contexts.ConnectionContext;
import interpreter.SQLInterpreter;

import java.util.ArrayList;

public class Interpreter extends Thread
{
    public RemoteBodhiServer server;

    public BodhiDatabase database;

    public ConnectionContext.InputThread inputthread;

    public ArrayList<String> buffer = new ArrayList<>();

    public SQLInterpreter interpreter;

    public void copyBuffer(ArrayList<String> buffer)
    {
        this.buffer.addAll(buffer);
    }

    public Interpreter(ConnectionContext.InputThread inputthread)
    {
        this.inputthread = inputthread;

        this.server = inputthread.server;

        this.interpreter = new SQLInterpreter(this.database);
    }

    @Override
    public void run()
    {
        while(true)
        {
            if(this.buffer.isEmpty())
            {
                try
                {
                    Thread.sleep(20);
                }
                catch (Exception e)
                {
                    return;
                }
            }
            else
            {
                String line = this.buffer.remove(0).strip();

                this.interpreter.interpret(line);
            }
        }
    }
}
