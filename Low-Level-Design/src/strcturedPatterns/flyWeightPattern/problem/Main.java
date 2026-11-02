package strcturedPatterns.flyWeightPattern.problem;

/*
    Consider we are developing a Google Maps kind of application.
    So If I want to show the forest area. I want to create a Tree, and then I want to add all the trees to the forest.
    But the problem is Google Maps doesn't mention the tree name or type or color.
    They handle all these things as common, so here I create 1000 trees, for same kind of thing I create 1000 objects.
    It is not a efficient way that's were we use FlyWeight Pattern.
*/

public class Main {
    public static void main(String[] args) {
        Forest forest = new Forest();

        for(int i = 0; i <=1000; i++){
            forest.plantTree(i,i,"Tree","Green","Rough");
        }

        forest.draw();
    }
}
