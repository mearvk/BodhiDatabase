package components.terminal;

import components.Component;
import system.System;

public class Terminal extends Component
{
    public Terminal.ThreadImplementation_001 thread_001;

    public Terminal()
    {
        System.Memory.reference.push("//terminal", this);
    }

    public static class ThreadImplementation_001 extends Thread
    {
        @Override
        public void run()
        {

        }
    }
}
