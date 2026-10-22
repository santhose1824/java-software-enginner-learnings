package pillars_of_object_oriented_programming.inheritance.hirarechal_inheritance;

// It is just an implementation of Hierarchical Inheritance.
// All the rules are same as the Single inheritance
public class Main {

    public static void main(String[] args) {

        // Parent Class
        Human human = new Human();
        System.out.println("Human Class object");
        System.out.println("Name of the human : "+human.name);
        System.out.println("Age of the human : "+human.age);
        System.out.println("Profession of the human : "+human.profession);

        // Child class Female

        Female female = new Female("female");
        System.out.println("Female Class object with one parameter");
        System.out.println("Name of the human : "+female.name);
        System.out.println("Age of the human : "+female.age);
        System.out.println("Profession of the human : "+female.profession);
        System.out.println("Gender of the human : "+female.gender);


        Female female2 = new Female("H.Mahalakshmi",45,"Housewife","female");
        System.out.println("Female Class object with parent parameters include");
        System.out.println("Name of the human : "+female2.name);
        System.out.println("Age of the human : "+female2.age);
        System.out.println("Profession of the human : "+female2.profession);
        System.out.println("Gender of the human : "+female2.gender);


        Male male = new Male("male");
        System.out.println("Male Class object with one parameter");
        System.out.println("Name of the human : "+male.name);
        System.out.println("Age of the human : "+male.age);
        System.out.println("Profession of the human : "+male.profession);
        System.out.println("Gender of the human : "+male.gender);

        Male male1 = new Male("P.Hari Krishnan",54,"Barber","male");
        System.out.println("Male Class object with parent parameters include");
        System.out.println("Name of the human : "+male1.name);
        System.out.println("Age of the human : "+male1.age);
        System.out.println("Profession of the human : "+male1.profession);
        System.out.println("Gender of the human : "+male1.gender);


    }


}
