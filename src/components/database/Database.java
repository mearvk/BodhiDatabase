package components.database;

import cases.UseDatabaseImpl;
import components.Component;
import parameter.Parameter;

public class Database extends Component
{
    public Parameter parameter;

    public String name;

    public String url;

    public static Database reference;

    public Database() throws Exception
    {
        Database.reference = this;
    }

    public Database(Parameter parameter) throws Exception
    {
        Database.reference = this;

        Database.reference.name = UseDatabaseImpl.Utility.getDatabaseName(parameter);

        Database.reference.url = UseDatabaseImpl.Utility.getDatabaseUrl(parameter);
    }

    public static class Properties
    {
        public String name;

        public String file;
    }

    public static class Reference
    {

    }
}
