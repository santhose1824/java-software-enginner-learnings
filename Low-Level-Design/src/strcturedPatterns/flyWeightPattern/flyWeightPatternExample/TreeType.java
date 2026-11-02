package strcturedPatterns.flyWeightPattern.flyWeightPatternExample;

public class TreeType {
    private String name;
    private String texture;
    private String color;

    public TreeType(String name, String texture, String color) {
        this.name = name;
        this.texture = texture;
        this.color = color;
    }

    public void draw(int x , int y){
        System.out.println("Drawing "+name+" tree at ("+ x +" , " + y +")");
    }
}
