package logging;

import java.util.ArrayList;

public class Logger
{
    public ArrayList<LoggingContext> contexts = new ArrayList<LoggingContext>(100);

    public static final Integer STDOUT = 0;

    public static  final Integer STDERR = 1;

    public static final Integer LOW = 2;

    public static final Integer MEDIUM = 3;

    public static final Integer HIGH = 4;

    public static final Integer SEVERE = 5;

    public static void log(Integer severity, String message, Exception exception, Integer which, Boolean echo)
    {
        if(message==null || which==null) return;

        LoggingContext context = new LoggingContext();

        if(which==Logger.STDOUT)
        {
            context.stdout = new StringBuffer(message);

            context.severity = severity;

            context.exception = exception;

            if(echo) System.out.println(message);
        }
        else if(which==Logger.STDERR)
        {
            context.stderr = new StringBuffer(message);

            context.severity = severity;

            context.exception = exception;

            if(echo) System.err.println(message);
        }
    }

    public static void log(String message, Exception exception, Integer which, Boolean echo)
    {
        if(message==null || which==null) return;

        LoggingContext context = new LoggingContext();

        if(which==Logger.STDOUT)
        {
            context.stdout = new StringBuffer(message);

            context.severity = LOW;

            context.exception = exception;

            if(echo) System.out.println(message);
        }
        else if(which==Logger.STDERR)
        {
            context.stderr = new StringBuffer(message);

            context.severity = LOW;

            context.exception = exception;

            if(echo) System.err.println(message);
        }
    }

    public static void log(String message, Integer which, Boolean echo)
    {
        if(message==null) return;

        if(which==null) return;

        LoggingContext context = new LoggingContext();

        if(which==Logger.STDOUT)
        {
            context.stdout = new StringBuffer(message);

            context.severity = LOW;

            if(echo) System.out.println(message);
        }
        else if(which==Logger.STDERR)
        {
            context.stderr = new StringBuffer(message);

            context.severity = LOW;

            if(echo) System.err.println(message);
        }
    }
}
