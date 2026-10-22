package object_class;

import java.util.Arrays;

public class Main {
    // Here also needs to put an exception
    public static void main(String[] args) throws CloneNotSupportedException {

        ObjectCloningExample cloningExample = new ObjectCloningExample(23,"Santhose");
        // So instead of doing this we can able to do like this.
//        ObjectCloningExample twin = new ObjectCloningExample(cloningExample) and cast it to the previous Object type;
        ObjectCloningExample twin = (ObjectCloningExample) cloningExample.clone();
        // Clone will copy  the values of one object to another.
        System.out.println(twin.age);
        System.out.println(twin.name);


        // This is called shallow copy when the primitives get new variables while copy but the object just pointing the reference variable to copy
        // So the changes in the clone will reflect in the original as well,
        System.out.println(Arrays.toString(twin.arr));

        twin.arr[0]=100;
        System.out.println(Arrays.toString(twin.arr));
        System.out.println(Arrays.toString(cloningExample.arr));

    }
}
