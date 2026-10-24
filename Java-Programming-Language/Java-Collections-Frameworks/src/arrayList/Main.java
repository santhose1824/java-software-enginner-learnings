package arrayList;

import java.util.ArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Always use the interface type as reference variable and concrete class type for object.
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<10;i++){
            // just add the element in the list.
            list.add(i);
        }

        // toString() method is override in the ArrayList class.
        System.out.println(list);

        // this will replace element in the position 3 with 400.
        list.set(3,400);
        System.out.println(list);

        // We can able to add one list to another by pass the list into the constructor of the ArrayList.
        // We can able to pass any class that implements Collection interface.
        List<Integer> list1 = new ArrayList<>(list);

        // now this list1 will print the same values with list.
        System.out.println(list1);


        list1.add(40);
        System.out.println(list1);


        // subList -(startIndex,lastIndex+1);
        List<Integer> list2 = list1.subList(0,4);
        System.out.println(list2);


        // ArrayList to array. - but this will return the object. array
        Integer[] arr = list.toArray(new Integer[list.size()]);
        for(int i:arr){
            System.out.print(i+" ");
        }


        // For know more about the methods in arrayList checkout the Java arrays section.


    }
}
