package structures;

import java.util.LinkedList;

public class Queue<SQLString> extends LinkedList<SQLString>
{
    public void enqueue(SQLString string)
    {
        this.add(string);
    }

    public SQLString dequeue()
    {
        return this.poll();
    }
}
