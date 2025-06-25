package interpreter;

public class InterpreterResult
{
    public String stdout;

    public String stderr;

    public InterpreterResult()
    {
        this.stdout = ".";

        this.stderr = ".";
    }

    public InterpreterResult(String stdout, String stderr)
    {
        this.stdout = stdout;

        this.stderr = stderr;
    }
}
