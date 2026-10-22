package pillars_of_object_oriented_programming.inheritance.multilevel_inheritance;

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
        // Hence it cannot be able to access the actions property from the Human class.
        Species species3 = new Human(2,2,2,23,"Speaking, Walking, Eating, Thinking, Dancing,");

        // This will assign only values to the name and gender in the Man class and rest of the values that are derived from the parent's are default.
        System.out.println("==============================================================");
        Man man = new Man("Santhose","Male");
        System.out.println("No.of eyes : "+man.eyes);
        System.out.println("No.of hands : "+man.hands);
        System.out.println("No.of legs : "+man.legs);
        System.out.println("Age of Species : "+man.age);
        System.out.println("Actions performed by the species : "+man.actions);
        System.out.println("Name of Human : "+man.name);
        System.out.println("Gender of Human : "+man.gender);
        System.out.println("==============================================================");
        // This will assign only values to the name and gender in the Man class and also set the values of parent class.
        Man man1 = new Man(2,2,2,23,"Speaking,Eating,Thinking,Walking","Santhose","male");
        System.out.println("No.of eyes : "+man1.eyes);
        System.out.println("No.of hands : "+man1.hands);
        System.out.println("No.of legs : "+man1.legs);
        System.out.println("Age of Species : "+man1.age);
        System.out.println("Actions performed by the species : "+man1.actions);
        System.out.println("Name of Human : "+man1.name);
        System.out.println("Gender of Human : "+man1.gender);
        System.out.println("==============================================================");

        Human man2 = new Man(2,2,2,23,"Speaking,Eating,Thinking,Walking");
        System.out.println("No.of eyes : "+man2.eyes);
        System.out.println("No.of hands : "+man2.hands);
        System.out.println("No.of legs : "+man2.legs);
        System.out.println("Age of Species : "+man2.age);
        System.out.println("Actions performed by the species : "+man2.actions);
//        System.out.println("Name of Human : "+man2.name);
//        System.out.println("Gender of Human : "+man2.gender);
        System.out.println("==============================================================");


    }
}
