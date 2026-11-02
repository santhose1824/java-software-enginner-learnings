package strcturedPatterns.flyWeightPattern.problem;

public class Tree {
    private int x;
    private int y;
    private String name;
    private String color;
    private String texture;

    public Tree(int x, int y, String name, String color, String texture) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(){
        System.out.println("Drawing tree at(" + x + ", " + y + ") with type "+name);
    }
}
