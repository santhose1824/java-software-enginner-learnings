package packages_static_non_static_singleton.singleton;

public class Main {
    public static void main(String[] args) {

        // These 3 reference variables are pointing to the same object in the memory

        Example instance1 = Example.getInstance();
        Example instance2 = Example.getInstance();
        Example instance3 = Example.getInstance();

        System.out.println(instance1 == instance2);
        System.out.println(instance1 == instance3);
    }
}
