package cases;

import components.database.DatabaseComponent;
import contexts.CreateDatabaseImplContext;
import contexts.UseImplContext;
import parameter.Parameter;
import system.System;

public class CreateDatabaseImpl extends UseCase
{
    public CreateDatabaseImpl_Step001 step001;

    public CreateDatabaseImpl_Step002 step002;

    public CreateDatabaseImpl_Step003 step003;

    public Parameter parameter;

    public CreateDatabaseImpl(String sqlString)
    {
        System.Memory.reference.push("//impl/createdatabase", this);

        //

        this.parameter = new Parameter(this, sqlString);

        //

        try
        {
            this.step001 = new CreateDatabaseImpl_Step001(this.parameter);

            this.step002 = new CreateDatabaseImpl_Step002(this.parameter);

            this.step003 = new CreateDatabaseImpl_Step003(this.parameter);
        }
        catch (Exception e)
        {
            return;
        }
    }

    public static class CreateDatabaseImpl_Step001
    {
        public CreateDatabaseImpl_Step001(Parameter parameter) throws Exception
        {
            System.Memory.reference.push("//step001", new PreConditionRunner(parameter));
        }
    }

    public static class CreateDatabaseImpl_Step002
    {
        public CreateDatabaseImpl_Step002(Parameter parameter) throws Exception
        {
            System.Memory.reference.push("//step002", new TaskRunner(parameter));
        }
    }

    public static class CreateDatabaseImpl_Step003
    {
        public CreateDatabaseImpl_Step003(Parameter parameter) throws Exception
        {
            System.Memory.reference.push("//step003", new PostConditionRunner(parameter));
        }
    }

    public static class PreConditionRunner
    {
        public PreConditionRunner(Parameter parameter) throws Exception
        {
            System.set("//database", parameter, CreateDatabaseImplContext.class);

            System.set("//database/properties/name", parameter, CreateDatabaseImplContext.class);

            System.set("//database/properties/file", parameter, CreateDatabaseImplContext.class);

            //

            DatabaseComponent database;

            database = (DatabaseComponent)System.pull("//database");

            database.properties.name = parameter.name = (String) System.pull("//database/properties/name");

            database.properties.file = parameter.file = (String) System.pull("//database/properties/file");

            //

            System.touch("//database");

            System.touch("//database/properties/name");

            System.touch("//database/properties/name");
        }
    }

    public static class TaskRunner
    {
        public TaskRunner(Parameter parameter) throws Exception
        {
            System.database.writer.database_persist(parameter);
        }
    }

    public static class PostConditionRunner
    {
        public PostConditionRunner(Parameter parameter) throws Exception
        {
            boolean result = System.database.reader.database_exists(parameter);
        }
    }
}

