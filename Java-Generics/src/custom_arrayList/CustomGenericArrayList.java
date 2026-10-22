package custom_arrayList;

import java.util.Arrays;


// The major problem in the previous CustomArrayList is that is only works for the int.
// Now we are going to create it for all the types.
// For that we use the Generics.

// Here we are try to create aCustom ArrayList.
// For that we use the concept of Generics.

// Here we put <T> that makes that this class will get any parameterized Class
// But to make fully with the T we got a lot of confuse, so we use Object class which is parent of all the class.
// Why specifically object because that the generic type T is not determined in the runtime.
public class CustomGenericArrayList<T> {

    // Internally in ArrayList we use normal array so that here also we provide normal array, but it can't be accessed so make it private.
    private Object [] array;
    // For ArrayList there is DEFAULT_SIZE is there if we haven't specified the initialCapacity via constructor.
    // So that we also have.
    private final static int DEFAULT_SIZE = 10;
    // This will keep track of the current size of array.
    private int size;

    // Constructor creates an array when the class object is created
    public CustomGenericArrayList(){
        this.array = new Object [DEFAULT_SIZE];
    }

    // Helper methods

    // This will check whether the array is full or not.
    public boolean isFull(){
        return this.size == array.length;
    }

    // This will resize the array by double the size of current array and add the elements into it.
    public void resize(){
        Object [] temp = new Object[array.length *2];
        for(int i = 0; i < array.length; i++){
            temp[i] = array[i];
        }

        this.array = temp;
    }


    // Add method - add elements in the array.
    // For that we allow user to only give the data that we want
    public void add(T num){
        // Checks if the array is full or not
        if(isFull()){
            // Resize the array
            resize();
        }
        // add array in current position and increment the size
        array[size++] = num;
    }

    // Remove method - remove the element in array.
    // This will not actually  remove the element just reduce the size of array.
    // So the element is present if we print is not shown, but if we add new element it will override it.
    public T remove(){
        T removed =  (T)array[--size];
        return removed;
    }

    // Get method - return the element at that index.
    public T get(int index){
        return (T)array[index];
    }

    // Set method - set the element at particular index.
    public void set(int index, int value){
        array[index] = value;
    }


    @Override
    public String toString() {
        return "CustomArrayList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {

        // This will prevent invalid type.
        // For the outputs we have null for non assign values, why because we use the Object type as array.
        CustomGenericArrayList<Integer> list = new CustomGenericArrayList<Integer>();

        // This will add only integers to it.
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // CustomArrayList{array=[1, 2, 3, 4, null, null, null, null, null, null], size=4}
        System.out.println(list);

        CustomGenericArrayList<String> list2 = new CustomGenericArrayList<String>();

        // This will add only strings in it.
        list2.add("Sam");
        list2.add("Ram");
        list2.add("Someone");

        // CustomArrayList{array=[Sam, Ram, Someone, null, null, null, null, null, null, null], size=3}
        System.out.println(list2);

    }
}
