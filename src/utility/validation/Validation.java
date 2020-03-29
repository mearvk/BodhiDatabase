package utility.validation;

import java.util.HashMap;

public class Validation
{
    public static Validation reference = new Validation();

    public HashMap<String, Action> map = new HashMap<String, Action>();

    public Validation()
    {
        Validation.reference = this;
    }

    public Validation push(String lookup, Class<?> klass)
    {

        return this;
    }

    public Validation push(String lookup, Action action)
    {
        if (lookup.equals("//validation/sql"))
        {

        }

        return this;
    }

    public static class Action implements Runnable
    {
        @Override
        public void run()
        {

        }
    }
}
