package messaging;

public class Messager
{
    public MessageQueue messageQueue = new MessageQueue();

    public static Messager reference = new Messager();

    public Messager()
    {
        Messager.reference = this;
    }

    public void push(String message, String var)
    {
        this.messageQueue.enqueue(message);
    }
}
