package strcturedPatterns.compositePattern.problem;

public class Product {
    private  String productName;
    private double price;

    public Product(String productName, double price) {
       this.productName = productName;
       this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void display(String indent){
        System.out.println(indent + productName + " " + price);
    }
}
