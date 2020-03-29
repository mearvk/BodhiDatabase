package exceptions;

public class Exception extends java.lang.Exception
{
    public static void push(Exception e)
    {
        System.out.println(e);
    }
}
