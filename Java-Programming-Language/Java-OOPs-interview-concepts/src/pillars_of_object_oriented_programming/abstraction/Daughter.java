package pillars_of_object_oriented_programming.abstraction;

public class Daughter extends Parent {

    int age;

    public Daughter(int age) {
        super(age);
    }

    // If we inherit the abstract class then we need to override the abstract methods.


    @Override
    void career(String name) {
        System.out.println("I am going to become a : "+name);
    }

    @Override
    void partner(String name, int age) {
        System.out.println("I love  "+name+" and he is "+age);
    }
}
