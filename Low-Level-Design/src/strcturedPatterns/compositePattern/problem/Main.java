package strcturedPatterns.compositePattern.problem;
import java.util.ArrayList;
import java.util.List;

/*
    Consider we are creating an ecommerce app.
    I could have products and products bundle.
    So the problem is starts when we start add to cart.
    The problem is adding to cart because it is two different types we probably give Cart to accept as Object class type.
    This is not a standard way because in Object class type it accept both the single product and product bundle as same.
    So because we make it as Object we cannot be able to get the products details directly we need to explicitly mentioned
    whether it is Product or Product Bundle.
*/

public class Main {
    public static void main(String[] args) {
        Product book = new Product("Atomic Habits",499);
        Product phone = new Product("Samsung S26",18000);
        Product earbuds = new Product("Air Pods",10000);
        Product charger = new Product("20W Charger",500);


        ProductBundle mobileCombo = new ProductBundle("Mobile combo");
        mobileCombo.addProduct(phone);
        mobileCombo.addProduct(earbuds);
        mobileCombo.addProduct(charger);

        ProductBundle schoolCombo = new ProductBundle("School Combo");
        schoolCombo.addProduct(new Product("Notebook",75.00));
        schoolCombo.addProduct(new Product("Pen Set",1480));
        schoolCombo.addProduct(new Product("Bag Pack",4000));

        // First Problem
        List<Object> cart = new ArrayList<>();
        cart.add(book);
        cart.add(mobileCombo);
        cart.add(schoolCombo);

        // Second Problem
        double total = 0;
        System.out.println("The Cart List is : ");
        for(Object item : cart){
            if(item instanceof Product){
                Product product = (Product) item;
                product.display(" ");
                total += product.getPrice();
            }else if(item instanceof ProductBundle){
                ProductBundle productBundle = (ProductBundle) item;
                productBundle.display(" ");
                total += productBundle.getPrice();
            }
        }

        System.out.println("Total Price: " + total);
        
    }
}
