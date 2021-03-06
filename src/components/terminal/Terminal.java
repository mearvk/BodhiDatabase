package components.terminal;


import components.Component;
import exceptions.ExceptionQueue;
import structures.Queue;
import structures.SQLString;
import system.System;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.*;


public class Terminal extends Component
{
    public Thread thread = new Thread();

    public static Terminal reference;

    //public UserInterface userinterface = new UserInterface();

    public Terminal() throws Exception
    {
        Terminal.reference = this;
    }

    public static class Thread extends java.lang.Thread
    {
        public Queue<SQLString> queue = new Queue<SQLString>();

        public Boolean running = true;

        @Override
        public void run()
        {

        }
    }

    public static class UserInterface
    {
        public Builder builder = new Builder(this);

        public UserInterface() throws Exception
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

            public UserInterface reference;

            public Step001 step001;

            public Step002 step002;

            public Step003 step003;

            //

            public Builder(UserInterface reference)
            {
                this.reference = reference;
            }

            //

            public static class Step001
            {
                public Step001(Builder builder) throws Exception
                {
                    System.storage("//jframe", builder.jframe = new JFrame());

                    System.storage("//jpanel", builder.jpanel = new JPanel());

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

                    //builder.jpanel.setDoubleBuffered(true);

                    //

                    builder.textpane.setBackground(Color.DARK_GRAY);

                    //builder.textpane.setDoubleBuffered(true);

                    //builder.textpane.setText("C:>");

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
            try
            {
                JPanel jpanel = (JPanel)System.storage("//jpanel");

                int w = jpanel.getWidth()-20;

                int h = jpanel.getHeight()-20;

                return new Dimension(w,h);
            }
            catch (Exception e)
            {
                ExceptionQueue queue;

                queue = new ExceptionQueue();

                queue.enqueue(e, e.getMessage());
            }

            return super.getPreferredSize();
        }
    }

    public static class JTextPane extends javax.swing.JTextPane
    {
        @Override
        public Dimension getPreferredSize()
        {
            try
            {
                Frame frame = (Frame)System.storage("//jframe");

                int w = frame.getWidth()-20;

                int h = frame.getHeight()-20;

                return new Dimension(w,h);
            }
            catch (Exception e)
            {
                ExceptionQueue queue;

                queue = new ExceptionQueue();

                queue.enqueue(e, e.getMessage());
            }

            return super.getPreferredSize();
        }
    }
}

