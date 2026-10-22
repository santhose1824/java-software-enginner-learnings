package pillars_of_object_oriented_programming.polymorphism.run_time_or_dynamic_polymorphism_method_overriding;

public class Main {
    public static void main(String[] args) {

        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Square square = new Square();

        // These will print the area methods inside each class.
        shape.area();
        circle.area();
        square.area();


        // Now the question is what happens if we do like below?
        Shapes shape1 = new Square();
        // Here the reference type is Shape as we know that the properties that are allowed to access based on its reference type.
        // So here the answer will be area of Shape as we think right, let's check
        // But the answer is "Area of square is side * side"
        // How it is happens?
        shape1.area();
    }
}
