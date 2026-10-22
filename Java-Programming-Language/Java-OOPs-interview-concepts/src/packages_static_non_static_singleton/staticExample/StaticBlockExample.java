package packages_static_non_static_singleton.staticExample;

public class StaticBlockExample {

    // All the static elements, blocks and methods are run only once when the class loads.
    //Step 1:
    static int a = 20;
    static int b;

    // Step 2:
    static{
        System.out.println("Static block example - inside the static block");
        b = 20*5;
    }

    public static void main(String[] args) {
        // Step3:
        StaticBlockExample example = new StaticBlockExample();
        System.out.println(StaticBlockExample.a + " "+StaticBlockExample.b);

        // This will add three with the b value
        StaticBlockExample.b +=3;
        System.out.println(StaticBlockExample.a + " "+StaticBlockExample.b);
    }
}
