package strcturedPatterns.compositePattern.compositePatternExample;

import strcturedPatterns.compositePattern.compositePatternExample.interfaces.Cart;

public class Product implements Cart {
    private  String productName;
    private double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void display(String indent){
        System.out.println(indent + productName + " " + price);
    }
}
