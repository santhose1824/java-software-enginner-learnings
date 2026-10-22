package interfaces.different_class;

// Here the Circle and the Square are 2 different class but implements the same interface.
public class Shapes {
    String shape;

    Shapes(){
        this.shape="Circle";
    }

    void area(){
        if(shape.equals("Circle")){
            Circle circle = new Circle();
            circle.area();
            shape="Square";
        }else{
            Square square = new Square();
            square.area();
            shape="Circle";
        }
    }

}
