package pillars_of_object_oriented_programming.polymorphism.complie_time_or_static_polymorphism_or_method_overloading;

// When the same method or constructor is created with different parameter, return type, ordering type is known as
// Method overloading or Compile time Polymorphism or Static Polymorphism.
public class Numbers {

    // This is known as the method overloading.

    int sum(int a, int b){
        return a + b;
    }

    int sum(int a, int b, int c){
        return a + b + c;
    }


    // Here we override the toString() from the parent class Object.
    // Object class is parent of all class we created in Java even we are not extends it, default extends Object class.
    @Override
    public String toString() {
        return "The toString() is overridden here.";
    }

    public static void main(String[] args) {
        Numbers n = new Numbers();

        // Which method is needs to call this will determine during the compile time.
        n.sum(12,45);
        n.sum(13,53,12);
    }
}
