package components.validation;

import structures.SQLString;

public class ValidationHandler
{
    public ValidationHandler validate(String string, Class klass)
    {
        if(string.equals("//validate/{sql}") && klass.isInstance(SQLString.class))
        {
            System.out.println("Check assign");
        }

        return this;
    }
}
