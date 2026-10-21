package pillars_of_object_oriented_programming.inheritance.hirarechal_inheritance;

public class Male extends Human{
    String gender;


    Male(){

    }

    Male(String gender){
        this.gender = gender;
    }

    Male(String name, int age, String profession, String gender) {
        super(name, age, profession);
        this.gender = gender;
    }
}
