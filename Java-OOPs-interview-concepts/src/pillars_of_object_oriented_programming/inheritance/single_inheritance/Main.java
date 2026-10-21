package pillars_of_object_oriented_programming.inheritance.single_inheritance;

public class Main {
    public static void main(String[] args) {
        // This will choose constructor based on the arguments we passed.
        Species species = new Species(2,0,4,30);
        //Copy constructor calling.
        Species species1 = new Species(species);

        System.out.println(species.eyes + " "+species.hands+" "+ species.legs+" "+ species.age);

        // this will call the non-parameter constructor of both Species and Human class.
        Human humanOne = new Human();

        // If anything in parent class is private,like age, eyes, hands or legs we cannot be able to access outside the class. not even in the child class file.

        // Print the values that are default set in the non-parameter constructor of both class.
        System.out.println("No.of eyes : "+humanOne.eyes);
        System.out.println("No.of hands : "+humanOne.hands);
        System.out.println("No.of legs : "+humanOne.legs);
        System.out.println("Age of Species : "+humanOne.age);
        System.out.println("Actions performed by the species : "+humanOne.actions);

        // I want to do something like this.
        // To do that we need to create constructor with super() in the child class.
        Human humanTwo = new Human(2,2,2,23,"Speaking, Walking, Eating, Thinking, Dancing,");
        System.out.println("No.of eyes : "+humanTwo.eyes);
        System.out.println("No.of hands : "+humanTwo.hands);
        System.out.println("No.of legs : "+humanTwo.legs);
        System.out.println("Age of Species : "+humanTwo.age);
        System.out.println("Actions performed by the species : "+humanTwo.actions);

        // let's do something like this
        // What are properties this reference variable of the object can access ?
        // Only to the parent class why?
        // Because the type of reference variable is determined which properties the object reference variable can access.
        // So, the species3 can access only the parent class properties because the reference variable type is Species,
        // Hence it cannot able to access the actions property from the Human class.
        Species species3 = new Human(2,2,2,23,"Speaking, Walking, Eating, Thinking, Dancing,");
    }
}
