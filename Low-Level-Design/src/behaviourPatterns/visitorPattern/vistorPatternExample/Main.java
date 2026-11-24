package behaviourPatterns.visitorPattern.vistorPatternExample;

import behaviourPatterns.visitorPattern.vistorPatternExample.interfaces.Item;
import behaviourPatterns.visitorPattern.vistorPatternExample.interfaces.ItemVisitor;
import behaviourPatterns.visitorPattern.vistorPatternExample.products.DigitalProduct;
import behaviourPatterns.visitorPattern.vistorPatternExample.products.GiftCard;
import behaviourPatterns.visitorPattern.vistorPatternExample.products.PhysicalProduct;
import behaviourPatterns.visitorPattern.vistorPatternExample.visitors.InvoiceVisitor;
import behaviourPatterns.visitorPattern.vistorPatternExample.visitors.ShippingCostVisitor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new PhysicalProduct("Shoes", 1.2));
        items.add(new DigitalProduct("Ebook", 100));
        items.add(new GiftCard("AMZ-500", 500));

        ItemVisitor invoiceGenerator = new InvoiceVisitor();
        ItemVisitor shippingCalculator = new ShippingCostVisitor();

        for (Item item : items) {
            item.accept(invoiceGenerator);
            item.accept(shippingCalculator);

            System.out.println("");
        }
    }
}
