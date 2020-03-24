import builder.Builder;
import system.System;

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

        builder.builder_step001 = new Builder.Builder_Step001();

        builder.builder_step002 = new Builder.Builder_Step002();

        builder.builder_step003 = new Builder.Builder_Step003();

        builder.builder_step004 = new Builder.Builder_Step004();

        builder.builder_step005 = new Builder.Builder_Step005();
    }
}
