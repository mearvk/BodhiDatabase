package logging;

public class LoggingContext
{
    public StringBuffer stdout = new StringBuffer();

    public StringBuffer stderr = new StringBuffer();

    public Integer severity;

    public Exception exception;
}
