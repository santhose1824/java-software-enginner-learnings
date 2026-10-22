package packages_static_non_static_singleton.staticExample;

public class Main {
    public static void main(String[] args) {
        Human santhose = new Human(23, "Santhose",30000,false);
        Human hayagreevan = new Human(23, "Hayagreevan",45000,true);

        // Here if we see the values are 1 for both the humans but there are 2 humans are there once we made static this will be 2 for both
        System.out.println(Human.population);
        System.out.println(Human.population);

        // non-static methods/ variables can't be used inside the static methods.
        // greetings(); - shows error
        // This will work
        Main main =  new Main();
        main.greetings();
    }


    static void greet(){
        System.out.println("Hello World");
    }

    void greetings(){
        System.out.println("Hello, welcome all");
        // In non-static member we can use static members
        greet();
    }
}
