public class LoopsDemo {

    public static void main(String[] args) {

        // ---- 5. for loop ----
        // for (datatype variable; condition; increment) { }
        System.out.println("--- for ---");
        for (int i = 0; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // A semicolon right after for(...) means an EMPTY body - the block below is NOT the loop body
        // for (int i = 0; i < 3; i++);   // <- this will not run the block as the loop body
        // { System.out.println("runs only once"); }

        // ---- 6. while loop ----
        System.out.println("--- while ---");
        int count = 0;
        while (count < 3) {
            System.out.println("Name " + count);
            count++;
        }
        // while (true) { ... }  -> infinite loop, needs a break

        // ---- 7. do while (runs at least once) ----
        System.out.println("--- do while ---");
        int n = 10;
        do {
            System.out.println("Something (runs once even though 10 < 3 is false)");
        } while (n < 3);

        // ---- for-each (enhanced for) ----
        System.out.println("--- for-each ---");
        int[] nums = {10, 20, 30};
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // ---- break and continue ----
        System.out.println("--- break / continue ---");
        for (int i = 1; i <= 10; i++) {
            if (i == 3) continue;     // skip 3
            if (i == 7) break;        // stop the loop at 7
            System.out.print(i + " ");
        }
        System.out.println();

        // ---- nested loops: pattern ----
        System.out.println("--- nested loops (triangle) ---");
        for (int row = 1; row <= 4; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // ---- labelled break ----
        System.out.println("--- labelled break ---");
        outer:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i * j == 4) break outer;
                System.out.print(i + "x" + j + " ");
            }
        }
        System.out.println();
    }
}
