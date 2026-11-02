package strcturedPatterns.compositePattern.compositePatternExample;

import strcturedPatterns.compositePattern.compositePatternExample.interfaces.Cart;

import java.util.ArrayList;
import java.util.List;

public class ProductBundle implements Cart {
    private String bundleName;
    private List<Cart> products = new ArrayList<>();

    public ProductBundle(String bundleName){
        this.bundleName = bundleName;
    }

    public void addProduct(Cart product){
        products.add(product);
    }

    @Override
    public double getPrice(){
        double total = 0;
        for (Cart product : products){
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public void display(String indent){
        System.out.println(indent + "Bundle Name: " + bundleName);
        for (Cart product : products){
            product.display(indent+" ");
        }
    }
}
