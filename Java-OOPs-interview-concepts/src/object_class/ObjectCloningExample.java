package object_class;

// This Cloneable in the lang package
public class ObjectCloningExample implements Cloneable {
    int age;
    String name;
    int[]arr;

    ObjectCloningExample(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr = new int[]{1,45,23,11,54,32};
    }

//    @Override
//    // This is the method that helps to clone the object, and it is necessary to throws Exception
//    public Object clone() throws CloneNotSupportedException {
//        // Shallow copy
//        return super.clone();
//    }

    @Override
    // This is the method that helps to clone the object, and it is necessary to throws Exception
    public Object clone() throws CloneNotSupportedException {

        ObjectCloningExample obj = (ObjectCloningExample)super.clone(); // this actually shallow copy.


        // make a deep copy
        obj.arr = new int[obj.arr.length];
        System.arraycopy(this.arr, 0, obj.arr, 0, obj.arr.length);

        return obj;

    }
}
