package exceptions;

public class DatabaseExistsAlreadyException extends Exception
{
    public DatabaseExistsAlreadyException(String message)
    {
        super(message);
    }
}
