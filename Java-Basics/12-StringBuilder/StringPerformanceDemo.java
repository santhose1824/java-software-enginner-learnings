public class StringPerformanceDemo {

    public static void main(String[] args) {

        // ---- The problem: String concatenation in a loop ----
        String series = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            series += ch;                  // creates a NEW String object every iteration
        }
        System.out.println(series);
        // Internally:
        //   i=0: "" + a   = "a"
        //   i=1: "a" + b  = "ab"
        //   i=2: "ab" + c = "abc"  ...
        // "a", "ab", "abc", ... "abcdefghi..." - all these intermediate Strings have no reference
        // variable at the end -> memory wastage. (Strings are immutable.)

        // ---- The solution: StringBuilder ----
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            builder.append(ch);            // modifies the SAME object
        }
        System.out.println(builder.toString());

        // ---- Measure the difference ----
        int n = 50_000;

        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < n; i++) s += "x";
        long stringTime = System.nanoTime() - start;

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("x");
        long builderTime = System.nanoTime() - start;

        System.out.println("\nAppending " + n + " times");
        System.out.println("String        : " + stringTime / 1_000_000 + " ms (length " + s.length() + ")");
        System.out.println("StringBuilder : " + builderTime / 1_000_000 + " ms (length " + sb.length() + ")");

        // ---- Random characters using Random ----
        java.util.Random random = new java.util.Random();
        StringBuilder randomStr = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int ch = 97 + (int) (random.nextFloat() * 26);   // 97 = 'a'
            randomStr.append((char) ch);
        }
        System.out.println("\nRandom 26 letters: " + randomStr);
    }
}
