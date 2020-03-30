package builder;

import components.network.NetworkComponent;
import components.parser.ParserComponent;
import components.persistence.PersistenceComponent;
import components.processor.ProcessorComponent;
import components.terminal.TerminalComponent;
import components.database.DatabaseComponent;

public class SQLBuilder
{
    public Builder_Step001 builder_step001;

    public Builder_Step002 builder_step002;

    public Builder_Step003 builder_step003;

    public Builder_Step004 builder_step004;

    public Builder_Step005 builder_step005;

    public Builder_Step006 builder_step006;


    public static class Builder_Step001
    {
        public Builder_Step001() throws Exception
        {
            ParserComponent parser = new ParserComponent();

            parser.thread.start();
        }
    }

    public static class Builder_Step002
    {
        public Builder_Step002() throws Exception
        {
            PersistenceComponent persistenceComponent = new PersistenceComponent();

            persistenceComponent.thread.start();
        }
    }

    public static class Builder_Step003
    {
        public Builder_Step003() throws Exception
        {
            NetworkComponent network = new NetworkComponent();

            network.thread.start();
        }
    }

    public static class Builder_Step004
    {
        public Builder_Step004() throws Exception
        {
            ProcessorComponent processor = new ProcessorComponent();

            processor.thread.start();
        }
    }

    public static class Builder_Step005
    {
        public Builder_Step005() throws Exception
        {
            TerminalComponent terminal = new TerminalComponent();

            terminal.thread.start();
        }
    }

    public static class Builder_Step006
    {
        public Builder_Step006() throws Exception
        {
            DatabaseComponent databaseComponent = new DatabaseComponent();

            //databaseComponent.thread.start();
        }
    }
}
