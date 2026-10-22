package pillars_of_object_oriented_programming.inheritance.multilevel_inheritance;

public class Man extends Human {
    String name;
    String gender;


    Man(){
        name = "Default name";
        gender = "Default gender";
    }

    Man(String name,String gender){
        this.name=name;
        this.gender = gender;
    }

    Man(int eyes, int hands, int legs, int age,String actions,String name,String gender){
        // This super will assign all the values that are needed for the parent class
        super(eyes,hands,legs,age,actions);
        this.name=name;
        this.gender=gender;
    }

    Man(int eyes, int hands, int legs, int age,String actions){
        // This super will assign all the values that are needed for the parent class
        super(eyes,hands,legs,age,actions);
    }
}
