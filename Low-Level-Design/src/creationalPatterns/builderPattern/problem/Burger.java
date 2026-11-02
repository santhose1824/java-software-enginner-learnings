package creationalPatterns.builderPattern.problem;

public class Burger {
    private String bunType;
    private String pattyType;

    /*
        In future If I add the followings
        private String sides;
        private List<String>toppings,
        private boolean isCheese;
    */

    public Burger(String bunType, String pattyType) {
        this.bunType = bunType;
        this.pattyType = pattyType;
    }

    /*
       I have to create a constructor like this.
        public Burger(String bunType, String pattyType, String sides, List<String> toppings, boolean isCheese ) {
            this.bunType = bunType;
            this.pattyType = pattyType;
            this.sides = sides;
            this.toppings = new ArrayList();
            this.isCheese = isCheese
        }
    */

}
