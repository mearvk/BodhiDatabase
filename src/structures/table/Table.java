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
    }

    public Table(Parameter parameter)
    {
        this.name = parameter.tblname;

        this.url = parameter.url;
    }
}
