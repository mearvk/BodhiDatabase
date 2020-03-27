import builder.Builder;
import components.parser.Parser;
import structures.Queue;
import structures.SQLString;
import system.System;

import java.util.LinkedList;

public class Main
{
    public static void main(String...args)
    {
        Main main = new Main();
    }

    public Main()
    {
        System system = new System();

        //

        Builder builder = new Builder();

        builder.builder_step001 = new Builder.Builder_Step001();    //step 1. <parser> component

        builder.builder_step002 = new Builder.Builder_Step002();    //step 2. <persistence> component

        builder.builder_step003 = new Builder.Builder_Step003();    //step 3. <network> component

        builder.builder_step004 = new Builder.Builder_Step004();    //step 4. <processor> component

        builder.builder_step005 = new Builder.Builder_Step005();    //step 5. <terminal> component

        //

        Queue<SQLString> queue = (Queue<SQLString>) System.pull("//parser/queue");

        //queue.add(new SQLString("CREATE DATABASE company"));

        queue.add(new SQLString("USE company"));

        queue.add(new SQLString("CREATE TABLE employees (EmployeeID int, Firstname varchar(255), Lastname varchar(255))"));
    }
}
