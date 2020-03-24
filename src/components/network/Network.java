package components.network;

import components.Component;
import system.System;

public class Network extends Component
{
    public Network.ThreadImplementation_001 thread_001;

    public Network()
    {
        System.Memory.reference.push("//network", this);
    }

    public static class ThreadImplementation_001 extends Thread
    {
        @Override
        public void run()
        {

        }
    }
}
