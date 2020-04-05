package structures.table;

import parameter.Parameter;

public class Table
{
    public Parameter parameter;

    public String name;

    public String url;

    public Table(Parameter parameter, Class<?> context)
    {
        this.parameter = parameter;

        this.name = parameter.table_name;

        this.url = parameter.url;
    }

    public Table(Parameter parameter)
    {
        this.name = parameter.table_name;

        this.url = parameter.url;
    }
}
