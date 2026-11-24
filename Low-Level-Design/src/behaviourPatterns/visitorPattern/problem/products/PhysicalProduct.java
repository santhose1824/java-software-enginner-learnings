package behaviourPatterns.visitorPattern.problem.products;

public class PhysicalProduct {
    void printInvoice(){
        System.out.println("Invoice for the Physical Product");
    }

    double calculateShippingCost(){
        return 89.0;
    }
}
