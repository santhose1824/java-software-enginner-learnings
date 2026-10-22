import java.util.Arrays;

/**
 * Example of every commonly used StringBuilder method.
 * StringBuilder = MUTABLE sequence of characters, NOT thread-safe, fast.
 * Run: java StringBuilderMethodsDemo.java
 */
public class StringBuilderMethodsDemo {

    static void title(String t) {
        System.out.println("\n=== " + t + " ===");
    }

    public static void main(String[] args) {

        title("Constructors");
        StringBuilder c1 = new StringBuilder();                 // empty, default capacity 16
        StringBuilder c2 = new StringBuilder("Santhosh");       // initial content; capacity = 16 + length
        StringBuilder c3 = new StringBuilder(30);               // custom initial capacity
        StringBuilder c4 = new StringBuilder(new StringBuilder("copy of CharSequence"));
        System.out.println(c1.capacity() + " " + c2.capacity() + " " + c3.capacity() + " " + c4);

        title("append(...) - add to the END (returns the same object, so calls can be chained)");
        StringBuilder sb = new StringBuilder();
        sb.append("Hello").append(' ').append(2026).append(' ').append(3.5).append(' ').append(true);
        sb.append(new char[]{'!', '!'});
        System.out.println(sb);

        title("insert(index, value)");
        sb = new StringBuilder("Hello World");
        sb.insert(5, ",");
        sb.insert(0, ">> ");
        System.out.println(sb);

        title("delete(start, end) - end exclusive");
        sb = new StringBuilder("Hello Java World");
        sb.delete(5, 10);
        System.out.println(sb);                                  // Hello World

        title("deleteCharAt(index)");
        sb = new StringBuilder("Helllo");
        sb.deleteCharAt(3);
        System.out.println(sb);                                  // Hello

        title("replace(start, end, string)");
        sb = new StringBuilder("I like Java");
        sb.replace(7, 11, "Python");
        System.out.println(sb);

        title("reverse()");
        sb = new StringBuilder("Santhosh");
        System.out.println(sb.reverse());

        title("setCharAt(index, char) / charAt(index)");
        sb = new StringBuilder("Jaba");
        sb.setCharAt(2, 'v');
        System.out.println(sb + " | charAt(0) = " + sb.charAt(0));

        title("length() / setLength(n)");
        sb = new StringBuilder("Hello World");
        System.out.println("length = " + sb.length());
        sb.setLength(5);                                         // truncates
        System.out.println(sb + " | length = " + sb.length());
        sb.setLength(7);                                         // pads with '\u0000'
        System.out.println("after setLength(7): length = " + sb.length());

        title("capacity() / ensureCapacity(n) / trimToSize()");
        sb = new StringBuilder();
        System.out.println("default capacity = " + sb.capacity());            // 16
        sb.append("12345678901234567");                                        // 17 chars -> grows
        System.out.println("after 17 chars   = " + sb.capacity());            // (16+1)*2 = 34   -> (old*2)+2
        sb.ensureCapacity(100);
        System.out.println("ensureCapacity(100) -> " + sb.capacity());
        sb.trimToSize();
        System.out.println("trimToSize -> " + sb.capacity());

        title("indexOf / lastIndexOf");
        sb = new StringBuilder("banana");
        System.out.println(sb.indexOf("an") + " " + sb.lastIndexOf("an") + " " + sb.indexOf("an", 2));

        title("substring / subSequence");
        sb = new StringBuilder("Santhosh");
        System.out.println(sb.substring(3) + " | " + sb.substring(0, 3) + " | " + sb.subSequence(1, 4));

        title("toString() - convert to an immutable String");
        String s = new StringBuilder("done").toString();
        System.out.println(s);

        title("compareTo / equals (equals is NOT overridden - compares references!)");
        StringBuilder x = new StringBuilder("abc");
        StringBuilder y = new StringBuilder("abc");
        System.out.println("x.equals(y)            = " + x.equals(y));                 // false
        System.out.println("x.compareTo(y)         = " + x.compareTo(y));              // 0
        System.out.println("x.toString().equals(..) = " + x.toString().equals(y.toString()));  // true

        title("isEmpty() (Java 15+) / chars()");
        System.out.println(new StringBuilder().isEmpty() + " | " + new StringBuilder("hello").chars().filter(c -> c == 'l').count());

        title("appendCodePoint / codePointAt");
        sb = new StringBuilder();
        sb.appendCodePoint(65).appendCodePoint(66);
        System.out.println(sb + " | codePointAt(0) = " + sb.codePointAt(0));

        title("getChars(srcBegin, srcEnd, dst[], dstBegin)");
        char[] dst = new char[5];
        new StringBuilder("Hello World").getChars(0, 5, dst, 0);
        System.out.println(Arrays.toString(dst));

        title("Practical: reverse a string, palindrome, remove vowels");
        String word = "madam";
        System.out.println(word + " palindrome? " + new StringBuilder(word).reverse().toString().equals(word));
        System.out.println("remove vowels: " + new StringBuilder("education").toString().replaceAll("[aeiou]", ""));

        title("Method chaining");
        System.out.println(new StringBuilder().append("a").append("b").insert(0, "X").reverse());
    }
}
