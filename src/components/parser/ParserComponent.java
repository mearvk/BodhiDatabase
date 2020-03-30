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

    public ParserComponent() throws Exception
    {
        System.push("//parser", this);

        System.push("//parser/queue", this.queue);

        System.push("//parser/thread", this.thread);
    }
}

