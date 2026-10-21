package pillars_of_object_oriented_programming.inheritance.hirarechal_inheritance;

public class Female extends Human {
    String gender;


    Female(){

    }

    Female(String gender) {
        super();
        this.gender = gender;
    }

    Female(String name, int age, String profession, String gender) {
        super(name, age, profession);
        this.gender = gender;
    }
}
