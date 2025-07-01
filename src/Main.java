import bodhi.BodhiDatabase;
import bodhi.network.RemoteBodhiServer;
import database.SQLColumn;
import database.SQLDatabase;
import database.SQLResult;
import database.SQLTable;

public class Main
{
    public static void main(String[] args)
    {
        BodhiDatabase database = new BodhiDatabase(new SQLDatabase("{microsoft}"));

        //
        
        SQLResult result;

        //
        
        result = database.insert("{microsoft}", new SQLTable("{employees}"));
        
        result = database.insert("{microsoft}", new SQLTable("{parking}"));

        result = database.insert("{microsoft}", new SQLTable("{resumes}"));

        result = database.insert("{microsoft}", new SQLTable("{security}"));

        //

        result = database.insert("{microsoft}", "{employees}", new SQLColumn("{first name}"));

        result = database.insert("{microsoft}", "{employees}", new SQLColumn("{last name}"));

        result = database.insert("{microsoft}", "{employees}", new SQLColumn("{phone number}"));

        result = database.insert("{microsoft}", "{employees}", new SQLColumn("{social security number}"));

        result = database.insert("{microsoft}", "{employees}", new SQLColumn("{salary}"));

        //

        result = database.insert("{microsoft}", "{employees}", "{first name}", "Max");

        result = database.insert("{microsoft}", "{employees}", "{last name}", "Rupplin");

        result = database.insert("{microsoft}", "{employees}", "{phone number}", "123-456-7890");

        result = database.insert("{microsoft}", "{employees}", "{social security number}", "111-222-3333");

        result = database.insert("{microsoft}", "{employees}", "{salary}", "$55.00/hr");

        //

        RemoteBodhiServer bodhiServer = new RemoteBodhiServer(database.context);

        /*

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

        */

        //

        //BodhiClient client = new BodhiClient();
    }
}

