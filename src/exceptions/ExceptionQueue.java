package exceptions;

public class ExceptionQueue extends java.lang.Exception
{
    public static ExceptionQueue reference = new ExceptionQueue();

    public ExceptionQueue()
    {
        ExceptionQueue.reference = this;
    }

    public static void enqueue(Exception e)
    {
        System.err.println(e.getMessage());
    }

    public static void enqueue(String message)
    {
        System.out.println(message);
    }
}
