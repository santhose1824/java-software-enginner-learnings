package packages_static_non_static_singleton.staticExample;

public class Human {
    int age;
    String name;
    int salary;
    boolean isMarry;

    // this gives 1 for every object we created so it is not depend on the object.
    // th property that are not related to object are mentioned to be static variables/ static methods.
    static long population = 0;


    public Human(int age, String name, int salary, boolean isMarry) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.isMarry = isMarry;
        Human.population +=1;
    }
}
