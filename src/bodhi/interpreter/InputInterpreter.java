package bodhi.interpreter;

import bodhi.BodhiDatabase;
import bodhi.contexts.ConnectionContext;
import interpreter.SQLInterpreter;

import java.util.ArrayList;

public class InputInterpreter extends Thread
{
    public ArrayList<String> buffer = new ArrayList<>();

    public ConnectionContext context;

    public SQLInterpreter interpreter;

    public void importMessages(ArrayList<String> buffer)
    {
        this.buffer.addAll(buffer);
    }

    public InputInterpreter()
    {
        this.interpreter = new SQLInterpreter();
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
