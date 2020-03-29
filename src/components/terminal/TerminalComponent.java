package components.terminal;


import components.Component;
import components.terminal.handler.TerminalCaseHandler;
import structures.Queue;
import structures.SQLString;
import system.System;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.*;
import java.util.LinkedList;

public class TerminalComponent extends Component
{
    public ThreadImplementation thread = new ThreadImplementation();

    public UIImplementation ui = new UIImplementation();

    public LinkedList<SQLString> queue = new LinkedList<SQLString>();

    public TerminalComponent()
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
            Queue<SQLString> queue = (Queue<SQLString>) System.pull("//terminal/");

            while (running)
            {
                try
                {
                    if(queue.peek()==null)
                    {
                        Thread.sleep(20,0);

                        continue;
                    }

                    TerminalCaseHandler handler = new TerminalCaseHandler(queue.dequeue());
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
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
            public JFrame jframe;

            public JMenuBar jmenubar;

            public JMenu file;

            public JMenu edit;

            public JPanel jpanel;

            public JTextPane textpane;

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
                    System.push("//jframe", builder.jframe = new JFrame());

                    System.push("//jpanel", builder.jpanel = new JPanel());

                    //

                    builder.jmenubar = new JMenuBar();

                    builder.file = new JMenu("File");

                    builder.edit = new JMenu("Edit");

                    builder.jpanel = new JPanel();

                    builder.textpane = new JTextPane();
                }
            }

            public static class Step002
            {
                public Step002(Builder builder)
                {
                    builder.jframe.add(builder.jpanel);

                    builder.jframe.setJMenuBar(builder.jmenubar);

                    builder.jmenubar.add(builder.file);

                    builder.jmenubar.add(builder.edit);

                    builder.jpanel.add(builder.textpane);
                }
            }

            public static class Step003
            {
                public Step003(Builder builder)
                {
                    builder.jframe.setSize(new Dimension(800,600));

                    builder.jframe.setLayout(new FlowLayout());

                    builder.jframe.setBackground(Color.DARK_GRAY);

                    builder.jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    //

                    builder.jpanel.setBackground(Color.DARK_GRAY);

                    builder.jpanel.setDoubleBuffered(true);

                    //

                    builder.textpane.setBackground(Color.DARK_GRAY);

                    builder.textpane.setDoubleBuffered(true);

                    builder.textpane.setText("C:>");

                    //

                    builder.jframe.setVisible(true);
                }
            }
        }
    }

    public static class JPanel extends javax.swing.JPanel
    {
        @Override
        public Dimension getPreferredSize()
        {
            JPanel jpanel = (JPanel)System.pull("//jpanel");

            int w = jpanel.getWidth()-20;

            int h = jpanel.getHeight()-20;

            return new Dimension(w,h);
        }
    }

    public static class JTextPane extends javax.swing.JTextPane
    {
        @Override
        public Dimension getPreferredSize()
        {
            Frame frame = (Frame)System.pull("//jframe");

            int w = frame.getWidth()-20;

            int h = frame.getHeight()-20;

            return new Dimension(w,h);
        }
    }
}
