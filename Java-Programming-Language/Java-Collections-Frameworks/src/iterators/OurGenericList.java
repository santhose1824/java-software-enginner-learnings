package iterators;

import java.util.Iterator;

// This class implements the Iterable so that we can able to traverse through the list.
public class OurGenericList<T> implements Iterable<T>{
    // To maintain a list we need a underlying data structure that we use array.
    private T[] items;
    // To keep track of array size we use size.
    private int size;

    public OurGenericList(){
        // Initialize the size of array as 0 when object is created.
        size = 0;
        // Create an object array with size of 100 in the type of  T
        items = (T[])new Object[100];
    }


    // allow us to add the items to the array.
    public void add (T item){
        items[size++] = item;
    }

    // allow us to get the items from the array.
    public T get (int index){
        return items[index];
    }

    // The below methods are  in Iterable interface.
    @Override
    public Iterator<T> iterator() {
        // we are creating the object of OutIterator class and send the object of OurGenericList class.
        return new OurIterator(this);
    }

    // This class will implement the Iterator for OurGenericList class.
    /*
        Why not implement Iterator in OurGenericList itself?
        It would compile, but it’s a bad design. An iterator holds its own position (index).
        If the list itself were the iterator, there would be only one position shared by everything.
        Two loops over the same list at once (nested loops, for example) would interfere with each other,
        and you couldn’t restart the traversal without resetting state.
        A fresh iterator object per iterator() call avoids this.
    */
    private class OurIterator implements Iterator<T>{
        private int index =0 ;
        private OurGenericList<T> list;

        public OurIterator(OurGenericList<T> list){
            this.list = list;
        }

        // This one checks whether the next element is available or not.
        @Override
        public boolean hasNext() {
            System.out.println("hasNext is called");
            return index < list.size ;
        }

        @Override
        public T next() {
            System.out.println("next is called");
            return list.items[index++];
        }
    }
}
