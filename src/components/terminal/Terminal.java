package components.terminal;

import cases.UseImpl;
import components.Component;
import structures.Queue;
import structures.SQLString;
import system.System;

import javax.swing.*;
import java.util.LinkedList;

public class Terminal extends Component
{
    public ThreadImplementation thread = new ThreadImplementation();

    public UIImplementation ui = new UIImplementation();

    public LinkedList<SQLString> queue = new LinkedList<SQLString>();

    public Terminal()
    {
        System.Memory.reference.push("//terminal", this);

        System.Memory.reference.push("//terminal/queue", this.queue);

        System.Memory.reference.push("//terminal/thread", this.thread);

        System.Memory.reference.push("//terminal/ui", this.ui);
    }

    public static class ThreadImplementation extends Thread
    {
        public Boolean running = true;

        @Override
        public void run()
        {
            //TODO dump chars from user interface into queue

            structures.Queue<SQLString> queue = (Queue<SQLString>) System.pull("//parser/queue");
        }
    }

    public static class UIImplementation
    {
        public Builder builder = new Builder(this);

        public UIImplementation()
        {
            builder.step001 = new Builder.Step001(this.builder);

            builder.step002 = new Builder.Step002(this.builder);

            builder.step003 = new Builder.Step003(this.builder);
        }

        public static class Builder
        {
            public JFrame jframe = new JFrame();

            public JMenuBar jmenubar = new JMenuBar();

            public JMenu file;

            public JMenu edit;

            public JPanel jpanel = new JPanel();

            public JTextPane jtextpane = new JTextPane();

            //

            public UIImplementation reference;

            public Step001 step001;

            public Step002 step002;

            public Step003 step003;

            //

            public Builder(UIImplementation reference)
            {
                this.reference = reference;
            }

            //

            public static class Step001
            {
                public Step001(Builder builder)
                {
                    builder.jframe = new JFrame();

                    builder.jmenubar = new JMenuBar();

                    builder.file = new JMenu("File");

                    builder.edit = new JMenu("Edit");

                    builder.jpanel = new JPanel();

                    builder.jtextpane = new JTextPane();
                }
            }

            public static class Step002
            {
                public Step002(Builder builder)
                {
                    builder.jframe.add(builder.jpanel);

                    builder.jframe.setJMenuBar(builder.jmenubar);

                    builder.jmenubar = new JMenuBar();

                    builder.file = new JMenu("File");

                    builder.edit = new JMenu("Edit");

                    builder.jpanel = new JPanel();

                    builder.jtextpane = new JTextPane();
                }
            }

            public static class Step003
            {
                public Step003(Builder builder)
                {

                }
            }
        }
    }

    public static class JFrame extends javax.swing.JFrame
    {

    }
}

