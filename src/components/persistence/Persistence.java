package components.persistence;

import components.Component;
import system.System;

public class Persistence extends Component
{
    public Persistence.ThreadImplementation_001 thread_001;

    public Persistence()
    {
        System.Memory.reference.push("//persistence", this);
    }

    public static class ThreadImplementation_001 extends Thread
    {
        @Override
        public void run()
        {

        }
    }
}
