package strcturedPatterns.flyWeightPattern.flyWeightPatternExample;


/*
    Here we are using the Factory + FlyWeight Pattern.
    So instead of making 1000 objects with same details which have to huge memory
    I reuse the same details whenever I need and then I create object only for what I need which makes the memory optimize,
*/

public class Main {
    public static void main(String[] args) {
        Forest forest = new Forest();
        for(int i=0;i<=1000;i++){
            for(int j=0;j<=1000;j++){
                forest.plantTree(i,j,"Tree","Green","Rough");
            }
        }
        forest.draw();
    }
}
