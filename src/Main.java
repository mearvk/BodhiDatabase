import builder.Builder;
import system.System;
import test.TestHarness;

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


        TestHarness harness = new TestHarness();

        harness.test_001 = new TestHarness.Test_001();

        harness.test_002 = new TestHarness.Test_002();

        harness.test_003 = new TestHarness.Test_003();

        harness.test_004 = new TestHarness.Test_004();

        harness.test_005 = new TestHarness.Test_005();
    }

}
