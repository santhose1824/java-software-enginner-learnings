package strcturedPatterns.compositePattern.problem;

import java.util.ArrayList;
import java.util.List;

public class ProductBundle {
    private String bundleName;
    private List<Product> products = new ArrayList<>();

    public ProductBundle(String bundleName){
        this.bundleName = bundleName;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public double getPrice(){
        double total = 0;
        for (Product product : products){
            total += product.getPrice();
        }
        return total;
    }

    public void display(String indent){
        System.out.println(indent + "Bundle Name: " + bundleName);
        for (Product product : products){
            product.display(indent+" ");
        }
    }
}
