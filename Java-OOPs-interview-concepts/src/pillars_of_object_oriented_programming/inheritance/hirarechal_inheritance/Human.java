package pillars_of_object_oriented_programming.inheritance.hirarechal_inheritance;

public class Human {
    String name;
    int age;
    String profession;


    Human(){
        this.name = "Default name";
        this.age = 0;
        this.profession = "Default profession";
    }

    Human(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }
}
