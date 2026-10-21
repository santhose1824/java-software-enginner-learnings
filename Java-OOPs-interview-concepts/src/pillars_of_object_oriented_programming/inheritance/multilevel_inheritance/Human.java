package pillars_of_object_oriented_programming.inheritance.multilevel_inheritance;

public class Human extends Species {
    String actions;
    Human(){
        this.actions = "Primary action is Speaking";
    }

    Human(int eyes, int hands, int legs, int age,String actions){
        super(eyes, hands, legs, age);
        this.actions = actions;
    }
}
