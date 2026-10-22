package pillars_of_object_oriented_programming.inheritance.single_inheritance;

public class Species {
    int eyes;
    int hands;
    int legs;
    int age;

    // When object creation if constructor has no argument this will call.
    Species(){
        this.eyes = 2;
        this.hands = 2;
        this.legs = 2;
        this.age = 1;
    }

    // When object creation if constructor has 4 argument this will call.
    Species(int eyes, int hands, int legs, int age){
            this.eyes = eyes;
            this.hands = hands;
            this.legs = legs;
            this.age = age;
    }

    // When object creation if constructor has 1 argument this will call.
    Species(int count){
        this.eyes = count;
        this.hands = count;
        this.legs = count;
        this.age = count;
    }

    // When object creation if constructor has object argument this will call.
    // This is called copy constructor.
    Species(Species copyOfSpecies){
        this.eyes = copyOfSpecies.eyes;
        this.hands = copyOfSpecies.hands;
        this.legs = copyOfSpecies.legs;
        this.age = copyOfSpecies.age;
    }

    public void information(){
        System.out.println("Species class is running");
    }
}
