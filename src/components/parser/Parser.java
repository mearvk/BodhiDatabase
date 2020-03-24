package components.parser;

import components.Component;
import system.System;

public class Parser extends Component
{
    public ThreadImplementation_001 thread_001;

    public Parser()
    {
        System.Memory.reference.push("//parser", this);
    }

    public static class ThreadImplementation_001 extends Thread
    {
        @Override
        public void run()
        {

        }
    }
}
