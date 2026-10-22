package enums;

public class EnumExample {
    enum Week{
        // These are enum constants.
        // Everything is public static final
        // Since it is final we cannot create child.
        // The type of this is week
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday,
        Sunday;

        // Constructor - this is not public or protected only private or default Why?
        // If it is public it allows to create new constants.
        // Because it is not the enum concept.
        Week(){
            System.out.println("Constructor called for : "+this);
        }

    }

    public static void main(String[] args) {
        Week week;
        week = Week.Monday;

        for(Week day:Week.values()){
            System.out.println(day);
        }


        System.out.println(week);
        // Position
        System.out.println(week.ordinal());
    }
}
