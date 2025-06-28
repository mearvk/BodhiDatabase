import bodhi.BodhiDatabase;
import bodhi.client.BodhiClient;
import contexts.BodhiDatabaseContext;
import bodhi.network.RemoteBodhiServer;
import database.SQLColumn;
import database.SQLDatabase;
import database.SQLResult;
import database.SQLTable;
import interpreter.SQLInterpreter;

public class Main
{
    public static void main(String[] args)
    {
        BodhiDatabaseContext bodhiDatabaseContext;

        BodhiDatabase bodhiDatabase = new BodhiDatabase(new SQLDatabase("{microsoft}"), bodhiDatabaseContext = new BodhiDatabaseContext("{context}"));

        //
        
        SQLResult result;

        //
        
        result = bodhiDatabase.insert("{microsoft}", new SQLTable("{employees}"));
        
        result = bodhiDatabase.insert("{microsoft}", new SQLTable("{parking}"));

        result = bodhiDatabase.insert("{microsoft}", new SQLTable("{resumes}"));

        result = bodhiDatabase.insert("{microsoft}", new SQLTable("{security}"));

        //

        result = bodhiDatabase.insert("{microsoft}", "{employees}", new SQLColumn("{first name}"));

        result = bodhiDatabase.insert("{microsoft}", "{employees}", new SQLColumn("{last name}"));

        result = bodhiDatabase.insert("{microsoft}", "{employees}", new SQLColumn("{phone number}"));

        result = bodhiDatabase.insert("{microsoft}", "{employees}", new SQLColumn("{social security number}"));

        result = bodhiDatabase.insert("{microsoft}", "{employees}", new SQLColumn("{salary}"));

        //

        result = bodhiDatabase.insert("{microsoft}", "{employees}", "{first name}", "Max");

        result = bodhiDatabase.insert("{microsoft}", "{employees}", "{last name}", "Rupplin");

        result = bodhiDatabase.insert("{microsoft}", "{employees}", "{phone number}", "123-456-7890");

        result = bodhiDatabase.insert("{microsoft}", "{employees}", "{social security number}", "111-222-3333");

        result = bodhiDatabase.insert("{microsoft}", "{employees}", "{salary}", "$55.00/hr");

        //

        RemoteBodhiServer bodhiServer = new RemoteBodhiServer(bodhiDatabaseContext);

        //

        SQLInterpreter interpreter = new SQLInterpreter(bodhiDatabase);

        interpreter.result = interpreter.interpret("ADD DATABASE '{citizens}'");

        interpreter.result = interpreter.interpret("DROP DATABASE '{citizens}'");

        //

        interpreter.result = interpreter.interpret("SELECT DATABASE '{citizens}' ADD TABLE '{ages}'");

        interpreter.result = interpreter.interpret("SELECT DATABASE '{citizens}' SELECT TABLE '{employees}' ADD COLUMN '{social security number}'");

        //


        interpreter.result = interpreter.interpret("SELECT DATABASE '{citizens}' DROP TABLE '{ages}'");

        interpreter.result = interpreter.interpret("SELECT DATABASE '{citizens}' SELECT TABLE '{employees}' DROP COLUMN '{social security number}'");

        //

        interpreter.result = interpreter.interpret("SELECT DATABASE '{citizens}' CHANGE TO '{citizen ID}'");

        interpreter.result = interpreter.interpret("SELECT DATABASE '{citizens}' SELECT TABLE '{ages}' CHANGE TO '{age}'");

        interpreter.result = interpreter.interpret("SELECT DATABASE '{citizens}' SELECT TABLE '{employees}' SELECT COLUMN '{social security number}' CHANGE TO '{SSN}'");

        //

        interpreter.result =  interpreter.interpret("INSERT INTO DATABASE '{microsoft}' WHERE TABLE EQUALS '{employees}' WHERE COLUMN EQUALS '{social security number}' SET VALUE '123-456-7890'");

        interpreter.result =  interpreter.interpret("UPDATE DATABASE '{microsoft}' WHERE TABLE EQUALS '{employees}' WHERE COLUMN EQUALS '{social security number}' SET VALUE '123-456-7890'");

        //

        //BodhiClient client = new BodhiClient();

        //client.start();
    }
}

