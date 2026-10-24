package iterators;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // create an object for the OurGenericList class.
        OurGenericList<Integer> integerList = new OurGenericList<>();

        // now add items to the list.
        for(int i = 1; i<=5; i++){
            integerList.add(i*2);
        }

        // Now you want to iterator over the list and do something.
        // For that we thought of using the for loop.
        // But we can't because we don't have the direct access to the array inside the OurGenericList class.
        // We can make it,but we need to make our underlying array public but it will violate encapsulation principle.
        // Also in future if I thought of change it into ArrayList from normal array, this client code will be affected.
        // Then what we will do ? there comes Iterable interface, we need to make sure that OurGenericList implements Iterable interfaces.
        // Now create an iterator type variable to hold our iterator.

       /*
           Iterator<Integer> iterator = integerList.iterator();

            while(iterator.hasNext()){
                System.out.print(iterator.next()+" ");
            }
            These lines will be replaced by for-each loop
        */

        for(int num : integerList){
            // If we run this it will call the hasNext() and next() that we have overridden in the OurGenericList class which comes from interface Iterator.
            System.out.print(num+" ");
            System.out.println();
        }
    }
}
