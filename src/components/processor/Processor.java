package components.processor;

import components.Component;
import system.System;

public class Processor extends Component
{
    public Processor.ThreadImplementation_001 thread_001;

    public Processor()
    {
        System.Memory.reference.push("//processor", this);
    }

    public static class ThreadImplementation_001 extends Thread
    {
        @Override
        public void run()
        {

        }
    }
}
