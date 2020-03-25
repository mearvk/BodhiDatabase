package builder;

import components.network.Network;
import components.parser.Parser;
import components.persistence.Persistence;
import components.processor.Processor;
import components.terminal.Terminal;

public class Builder
{
    public Builder_Step001 builder_step001;

    public Builder_Step002 builder_step002;

    public Builder_Step003 builder_step003;

    public Builder_Step004 builder_step004;

    public Builder_Step005 builder_step005;


    public static class Builder_Step001
    {
        public Builder_Step001()
        {
            Parser parser = new Parser();

            parser.thread.start();
        }
    }

    public static class Builder_Step002
    {
        public Builder_Step002()
        {
            Persistence persistence = new Persistence();

            persistence.thread.start();
        }
    }

    public static class Builder_Step003
    {
        public Builder_Step003()
        {
            Network network = new Network();

            network.thread.start();
        }
    }

    public static class Builder_Step004
    {
        public Builder_Step004()
        {
            Processor processor = new Processor();

            processor.thread.start();
        }
    }

    public static class Builder_Step005
    {
        public Builder_Step005()
        {
            Terminal terminal = new Terminal();

            terminal.thread.start();
        }
    }

}
