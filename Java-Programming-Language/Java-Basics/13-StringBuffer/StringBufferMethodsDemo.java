import java.util.Arrays;

/**
 * Example of every commonly used StringBuffer method.
 * StringBuffer = MUTABLE sequence of characters, THREAD-SAFE (synchronized methods), slower.
 * Run: java StringBufferMethodsDemo.java
 */
public class StringBufferMethodsDemo {

    static void title(String t) {
        System.out.println("\n=== " + t + " ===");
    }

    public static void main(String[] args) {

        title("Constructors (3 from my notes + CharSequence)");
        StringBuffer buffer = new StringBuffer();               // Constructor 1: empty, default capacity 16
        StringBuffer bf = new StringBuffer("Santhosh");         // Constructor 2: with initial string (capacity = 16 + 8)
        StringBuffer bf30 = new StringBuffer(30);               // Constructor 3: with capacity
        System.out.println(buffer.capacity() + " " + bf.capacity() + " " + bf30.capacity());
        System.out.println("Default capacity of StringBuffer is " + new StringBuffer().capacity());

        title("append(...) - returns the same object, chainable");
        buffer.append("Sam");
        System.out.println(buffer.toString());
        buffer.append(' ').append(25).append(' ').append(99.5).append(' ').append(false);
        System.out.println(buffer);

        title("insert(index, value)");
        StringBuffer sb = new StringBuffer("Hello World");
        sb.insert(5, ",");
        sb.insert(0, ">> ");
        System.out.println(sb);

        title("delete(start, end) - end exclusive");
        sb = new StringBuffer("Hello Java World");
        sb.delete(5, 10);
        System.out.println(sb);

        title("deleteCharAt(index)");
        sb = new StringBuffer("Helllo");
        sb.deleteCharAt(3);
        System.out.println(sb);

        title("replace(start, end, string)");
        sb = new StringBuffer("I like Java");
        sb.replace(7, 11, "Python");
        System.out.println(sb);

        title("reverse()");
        System.out.println(new StringBuffer("Santhosh").reverse());

        title("setCharAt(index, char) / charAt(index)");
        sb = new StringBuffer("Jaba");
        sb.setCharAt(2, 'v');
        System.out.println(sb + " | charAt(0) = " + sb.charAt(0));

        title("length() / setLength(n)");
        sb = new StringBuffer("Hello World");
        System.out.println("length = " + sb.length());
        sb.setLength(5);
        System.out.println(sb + " | length = " + sb.length());

        title("capacity() / ensureCapacity(n) / trimToSize()");
        sb = new StringBuffer();
        System.out.println("default  = " + sb.capacity());            // 16
        sb.append("12345678901234567");
        System.out.println("after 17 chars = " + sb.capacity());      // 34
        sb.ensureCapacity(100);
        System.out.println("ensureCapacity(100) = " + sb.capacity());
        sb.trimToSize();
        System.out.println("trimToSize = " + sb.capacity());

        title("indexOf / lastIndexOf");
        sb = new StringBuffer("banana");
        System.out.println(sb.indexOf("an") + " " + sb.lastIndexOf("an"));

        title("substring / subSequence");
        sb = new StringBuffer("Santhosh");
        System.out.println(sb.substring(3) + " | " + sb.substring(0, 3) + " | " + sb.subSequence(1, 4));

        title("toString()");
        System.out.println(new StringBuffer("done").toString());

        title("compareTo / equals (equals NOT overridden)");
        StringBuffer x = new StringBuffer("abc");
        StringBuffer y = new StringBuffer("abc");
        System.out.println(x.equals(y) + " " + x.compareTo(y));

        title("isEmpty() (Java 15+) / chars()");
        System.out.println(new StringBuffer().isEmpty() + " | " + new StringBuffer("hello").chars().filter(c -> c == 'l').count());

        title("appendCodePoint / codePointAt / getChars");
        sb = new StringBuffer();
        sb.appendCodePoint(65).appendCodePoint(66);
        System.out.println(sb + " | " + sb.codePointAt(0));
        char[] dst = new char[5];
        new StringBuffer("Hello World").getChars(0, 5, dst, 0);
        System.out.println(Arrays.toString(dst));

        title("Random characters (from my notes)");
        java.util.Random random = new java.util.Random();
        StringBuffer rnd = new StringBuffer();
        for (int i = 0; i < 26; i++) {
            int ch = 97 + (int) (random.nextFloat() * 26);
            rnd.append((char) ch);
        }
        System.out.println(rnd);
    }
}
