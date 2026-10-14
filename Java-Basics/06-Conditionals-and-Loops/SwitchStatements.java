public class SwitchStatements {

    public static void main(String[] args) {
        int day = 3;

        // ---- Syntax 1: classic switch (needs break!) ----
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Not Valid");
        }

        // ---- Syntax 2: new arrow form (Java 14+) - no break needed ----
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.out.println("Not Valid");
        }

        // ---- Multiple labels in one case ----
        switch (day) {
            case 6, 7 -> System.out.println("Weekend");
            default   -> System.out.println("Weekday");
        }

        // ---- switch as an expression (returns a value) ----
        String name = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Other";
        };
        System.out.println("Expression result: " + name);

        // ---- Fall-through (forgetting break) ----
        System.out.println("--- fall through demo ---");
        switch (2) {
            case 1: System.out.println("one");
            case 2: System.out.println("two");     // starts here...
            case 3: System.out.println("three");   // ...and keeps running
            default: System.out.println("default");
        }

        // ---- switch on a String ----
        String fruit = "apple";
        switch (fruit) {
            case "apple" -> System.out.println("Red fruit");
            case "banana" -> System.out.println("Yellow fruit");
            default -> System.out.println("Unknown fruit");
        }
    }
}
