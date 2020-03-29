package components.validation;

import contexts.CreateDatabaseImplContext;
import parameter.Parameter;
import system.System;

public class ValidationComponent
{
    public static ValidationComponent reference = new ValidationComponent();

    public ValidationComponent()
    {
        ValidationComponent.reference = this;
    }

    public ValidationComponent push(String lookup, Class<?> klass)
    {
        return this;
    }

    public ValidationComponent touch(String bodhi, Parameter parameter, Class<?> klass) throws Exception
    {
        if(bodhi.equals("//database") && klass.isAssignableFrom(CreateDatabaseImplContext.class))
        {
            System.touch("//database");
        }

        return this;
    }
}
