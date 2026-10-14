public class StringComparison {

    public static void main(String[] args) {

        // Two ways to compare Strings:
        //   1) == comparator  -> compares REFERENCES (do both variables point to the same object?)
        //   2) .equals method -> compares VALUES
        String a = "Kunal";
        String b = "Kunal";
        System.out.println("a == b      : " + (a == b));            // true (same pooled object)

        String c = new String("Kunal");
        String d = new String("Kunal");
        System.out.println("c == d      : " + (c == d));            // false (new objects created)
        System.out.println("c.equals(d) : " + c.equals(d));         // true

        // When you only need to check the value -> use .equals()
        System.out.println("a.equals(c) : " + a.equals(c));         // true

        // equalsIgnoreCase
        System.out.println("equalsIgnoreCase : " + "JAVA".equalsIgnoreCase("java"));

        // compareTo -> lexicographic (dictionary) order
        //   0  -> equal, negative -> first is smaller, positive -> first is greater
        System.out.println("\"apple\".compareTo(\"banana\") = " + "apple".compareTo("banana"));   // negative
        System.out.println("\"banana\".compareTo(\"apple\") = " + "banana".compareTo("apple"));   // positive
        System.out.println("\"java\".compareTo(\"java\")     = " + "java".compareTo("java"));     // 0
        System.out.println("compareToIgnoreCase = " + "Java".compareToIgnoreCase("jAVA"));         // 0

        // Safe-null comparison: put the literal first
        String input = null;
        System.out.println("\"admin\".equals(null) = " + "admin".equals(input));   // false, no exception
        // input.equals("admin");   // NullPointerException
        System.out.println("Objects.equals = " + java.util.Objects.equals(input, null));  // true
    }
}
