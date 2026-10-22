package packages_static_non_static_singleton.singleton;

// Singleton class are not allow users to create more than one object.
public class Example {
    // We make the constructor private so the users cannot be able to create an object.
    private Example(){

    }

    // here we create a variable to track of the object is created or not.
    private static Example instance;

    // This method will check if instance is already created or not if created it returns the existing instance else create new object.
    // So, how many times we create an object it points to the same object.
    public static Example getInstance(){
        if(instance == null){
            instance = new Example();
        }
        return instance;
    }
}
