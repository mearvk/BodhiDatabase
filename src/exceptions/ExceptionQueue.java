package exceptions;

public class ExceptionQueue extends java.lang.Exception
{
    public static ExceptionQueue reference = new ExceptionQueue();

    public ExceptionQueue()
    {
        ExceptionQueue.reference = this;
    }

    public static void enqueue(String message)
    {
        System.out.println(message);
    }

    public static void enqueue(String message, String bodhi)
    {
        System.out.println(message);
    }

    public static void enqueue(String message, String bodhi, String target)
    {
        System.out.println(message);
    }

    public static class ThreadImplementation
    {

    }
}
