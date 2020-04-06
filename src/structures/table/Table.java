package structures.table;

import parameter.Parameter;

public class Table
{
    public Parameter parameter;

    public String name;

    public String url;

    public Class<?> context;

    public Table(Parameter parameter, Class<?> context)
    {
        this.parameter = parameter;

        this.context = context;

        this.name = parameter.table_name;

        this.url = parameter.url;
    }
}
