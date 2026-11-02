package strcturedPatterns.compositePattern.compositePatternExample;



import strcturedPatterns.compositePattern.compositePatternExample.interfaces.Cart;
import java.util.ArrayList;
import java.util.List;

/*
     So instead of creating the 2 different class and make it Object and all the things
     I simply create an interface which makes to use common feature
     And add the single product on the type of Cart and add the Bundle but the Product of bundle in type of Cart
     Finally without Object class type I can fetch them or add them in type of Cart

*/

public class Main {
    public static void main(String[] args) {
        Cart book = new Product("Atomic Habits",499);
        Cart phone = new Product("Samsung S26",18000);
        Cart earbuds = new Product("Air Pods",10000);
        Cart charger = new Product("20W Charger",500);


        ProductBundle mobileCombo = new ProductBundle("Mobile combo");
        mobileCombo.addProduct(phone);
        mobileCombo.addProduct(earbuds);
        mobileCombo.addProduct(charger);

        ProductBundle schoolCombo = new ProductBundle("School Combo");
        schoolCombo.addProduct(new Product("Notebook",75.00));
        schoolCombo.addProduct(new Product("Pen Set",1480));
        schoolCombo.addProduct(new Product("Bag Pack",4000));

        List<Cart> cart = new ArrayList<>();
        cart.add(book);
        cart.add(mobileCombo);
        cart.add(schoolCombo);

        double total = 0;
        System.out.println("The Cart List is : ");
        for(Cart item : cart){
            item.display(" ");
            total = total + item.getPrice();
        }

        System.out.println("Total Price: " + total);
    }
}
