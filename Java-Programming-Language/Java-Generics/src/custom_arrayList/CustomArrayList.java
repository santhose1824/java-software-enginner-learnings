package custom_arrayList;

import java.util.ArrayList;
import java.util.Arrays;


// Here we are try to create aCustom ArrayList.
// For that we use the concept of Generics.

public class CustomArrayList {

    // Internally in ArrayList we use normal array so that here also we provide normal array, but it can't be accessed so make it private.
    private int [] array;
    // For ArrayList there is DEFAULT_SIZE is there if we haven't specified the initialCapacity via constructor.
    // So that we also have.
    private final static int DEFAULT_SIZE = 10;
    // This will keep track of the current size of array.
    private int size;

    // Constructor creates an array when the class object is created
    public CustomArrayList(){
        this.array = new int [DEFAULT_SIZE];
    }

    // Helper methods

    // This will check whether the array is full or not.
    public boolean isFull(){
        return this.size == array.length;
    }

    // This will resize the array by double the size of current array and add the elements into it.
    public void resize(){
        int [] temp = new int[array.length *2];
        for(int i = 0; i < array.length; i++){
            temp[i] = array[i];
        }

        this.array = temp;
    }


    // Add method - add elements in the array.
    // For that we allow user to only give the data that we want
    public void add(int num){
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
    public int remove(){
        int removed =  array[--size];
        return removed;
    }

    // Get method - return the element at that index.
    public int get(int index){
        return array[index];
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

        CustomArrayList list = new CustomArrayList();

        // Here the size of internal array is 10 but, it will give us how many elements we added as size.
        list.add(3);
        list.add(2);
        list.add(4);

        System.out.println(list);

        // For this the internal array size is 14 but the not no.of elements we added is 14, so size is 14.
        for(int i = 0; i<14; i++){
            list.add(i);
        }

        System.out.println(list);

    }
}
