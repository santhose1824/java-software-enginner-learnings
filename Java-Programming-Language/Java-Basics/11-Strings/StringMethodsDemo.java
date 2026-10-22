import java.util.Arrays;

/**
 * Examples of the commonly used String methods.
 * Strings are immutable - every method that "changes" a string returns a NEW string.
 */
public class StringMethodsDemo {

    static void title(String t) {
        System.out.println("\n=== " + t + " ===");
    }

    public static void main(String[] args) {
        String a = "Santhosh";
        String text = "  Hello Java World  ";

        title("length() / isEmpty() / isBlank()");
        System.out.println(a.length());                       // 8
        System.out.println("".isEmpty());                     // true
        System.out.println("   ".isEmpty() + " " + "   ".isBlank());   // false true

        title("charAt(index) - access a particular index");
        System.out.println(a.charAt(0));                      // 'S'
        System.out.println(a.charAt(a.length() - 1));         // 'h'

        title("indexOf / lastIndexOf");
        System.out.println(a.indexOf('h'));                   // 3
        System.out.println(a.lastIndexOf('h'));               // 7
        System.out.println(a.indexOf("hos"));                 // 3
        System.out.println(a.indexOf('z'));                   // -1  (not found)
        System.out.println(a.indexOf('h', 4));                // search from index 4 -> 7

        title("substring(begin) / substring(begin, end)  (end exclusive)");
        System.out.println(a.substring(3));                   // hosh
        System.out.println(a.substring(0, 3));                // San

        title("contains / startsWith / endsWith");
        System.out.println(a.contains("tho"));                // true
        System.out.println(a.startsWith("San"));              // true
        System.out.println(a.endsWith("sh"));                 // true

        title("toUpperCase / toLowerCase");
        System.out.println(a.toUpperCase());
        System.out.println(a.toLowerCase());

        title("trim() / strip() / stripLeading() / stripTrailing()");
        System.out.println("[" + text.trim() + "]");
        System.out.println("[" + text.strip() + "]");
        System.out.println("[" + text.stripLeading() + "]");
        System.out.println("[" + text.stripTrailing() + "]");

        title("replace / replaceAll / replaceFirst");
        System.out.println("banana".replace('a', 'o'));                 // bonono
        System.out.println("banana".replace("na", "NA"));               // baNANA
        System.out.println("a1b22c333".replaceAll("[0-9]+", "#"));      // a#b#c#   (regex)
        System.out.println("banana".replaceFirst("a", "A"));            // bAnana

        title("split(regex)");
        String csv = "java,python,c++";
        String[] parts = csv.split(",");
        System.out.println(Arrays.toString(parts) + " length=" + parts.length);
        System.out.println(Arrays.toString("a b   c".split("\\s+")));   // split on any whitespace
        System.out.println(Arrays.toString("a-b-c-d".split("-", 2)));   // limit = 2

        title("join (static) / concat / repeat");
        System.out.println(String.join("-", "2026", "10", "14"));
        System.out.println(String.join(", ", java.util.List.of("A", "B", "C")));
        System.out.println("Hello".concat(" World"));
        System.out.println("ab".repeat(3));

        title("toCharArray() / valueOf() / chars()");
        char[] chars = a.toCharArray();
        System.out.println(Arrays.toString(chars));
        Arrays.sort(chars);
        System.out.println(new String(chars) + " / " + String.valueOf(chars));  // sorted letters
        System.out.println(String.valueOf(123) + String.valueOf(true) + String.valueOf(3.5));
        System.out.println(a.chars().filter(ch -> ch == 'h').count());          // count of 'h' -> 2

        title("compareTo / equals / equalsIgnoreCase");
        System.out.println(a.equals("Santhosh") + " " + a.equalsIgnoreCase("SANTHOSH") + " " + a.compareTo("Sam"));

        title("matches(regex)");
        System.out.println("12345".matches("\\d+"));
        System.out.println("abc123".matches("\\d+"));

        title("hashCode() / intern()");
        System.out.println("Java".hashCode());
        System.out.println(new String("Java").intern() == "Java");   // true

        title("format() / formatted()");
        System.out.println(String.format("Name: %s, Age: %d, Marks: %.2f", "Santhosh", 25, 98.456));
        System.out.println("Hi %s".formatted("Sam"));

        title("codePointAt() / getBytes()");
        System.out.println(a.codePointAt(0));                          // 83 ('S')
        System.out.println(Arrays.toString("AB".getBytes()));          // [65, 66]

        title("lines() / strip indent / text block");
        "line1\nline2\nline3".lines().forEach(System.out::println);
        String block = """
                Hello,
                  Text Block!
                """;
        System.out.print(block);

        title("reverse a String (String has NO reverse() - use StringBuilder)");
        System.out.println(new StringBuilder(a).reverse());

        title("Palindrome check");
        String p = "madam";
        System.out.println(p + " palindrome? " + p.equals(new StringBuilder(p).reverse().toString()));

        title("copyValueOf / contentEquals / regionMatches");
        System.out.println(String.copyValueOf(new char[]{'J', 'a', 'v', 'a'}));
        System.out.println("abc".contentEquals(new StringBuilder("abc")));
        System.out.println("HelloWorld".regionMatches(true, 5, "WORLD", 0, 5));
    }
}
