package components.parser;

import components.Component;
import components.parser.thread.ParserThread;
import structures.Queue;
import structures.SQLString;
import system.System;

public class ParserComponent extends Component
{
    public ParserThread thread = new ParserThread();

    public Queue<SQLString> queue = new Queue<SQLString>();

    public ParserComponent()
    {
        System.Memory.reference.push("//parser", this);

        System.Memory.reference.push("//parser/queue", this.queue);

        System.Memory.reference.push("//parser/thread", this.thread);
    }
}

