package packages_static_non_static_singleton.staticExample;

// We can put a class inside another class
// The outer class should not be static
// The inner class may or may not be static
public class InnerClass {

    static class Test{
        String name;

        public Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        // This will give error because the inner class is not static hence it depends on the object of outer class
        // If you put the inner class as static we will not get the error.
        // The below 2 gives the different output Santhose and Someone why?
        /* Because the Test Class is static so the Test Class is not depend on objects of Inner Class.
            but, the properties of the Test Class is not static so that are all depend on the objects,
            since if we change value via object the value is changed and that's why we get 2 different results
        */
        Test test = new Test("Santhose");
        Test test1 = new Test("Someone");


        System.out.println(test.name);
        System.out.println(test1.name);
    }

}
