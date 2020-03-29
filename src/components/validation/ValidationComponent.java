package components.validation;

import parameter.Parameter;

import java.util.HashMap;

public class ValidationComponent
{
    public static ValidationComponent reference = new ValidationComponent();

    public HashMap<String, Action> map = new HashMap<String, Action>();

    public ValidationComponent()
    {
        ValidationComponent.reference = this;
    }

    public ValidationComponent push(String lookup, Class<?> klass)
    {

        return this;
    }

    public ValidationComponent push(String lookup, Action action)
    {
        if (lookup.equals("//validation/sql"))
        {

        }

        return this;
    }

    public ValidationComponent touch(String name, Parameter parameter, Class<?> klass) throws Exception
    {
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
