import builder.SQLBuilder;
import system.System;
import test.SQLHarness;

public class Main
{
    public static void main(String...args)
    {
        Main main = new Main();
    }

    public Main()
    {
        try
        {
            System system = new System();

            //

            SQLBuilder builder = new SQLBuilder();

            builder.builder_step001 = new SQLBuilder.Builder_Step001();    //step 1. <parser>

            builder.builder_step002 = new SQLBuilder.Builder_Step002();    //step 2. <persistence>

            builder.builder_step003 = new SQLBuilder.Builder_Step003();    //step 3. <network>

            builder.builder_step004 = new SQLBuilder.Builder_Step004();    //step 4. <processor>

            builder.builder_step005 = new SQLBuilder.Builder_Step005();    //step 5. <terminal>

            builder.builder_step006 = new SQLBuilder.Builder_Step006();    //step 6. <database>

        }
        catch (Exception e)
        {
            e.addSuppressed(e);
        }

        //


        SQLHarness harness = new SQLHarness();

        harness.test_001 = new SQLHarness.Test_001();              //step 1. run test harness #1

        //harness.test_002 = new SQLHarness.Test_002();              //step 2. run test harness #2

        //harness.test_003 = new SQLHarness.Test_003();              //step 3. run test harness #3

        //harness.test_004 = new SQLHarness.Test_004();              //step 4. run test harness #4

        //harness.test_005 = new SQLHarness.Test_005();              //step 5. run test harness #5

        //harness.test_006 = new SQLHarness.Test_006();              //step 6. run test harness #5
    }

}
