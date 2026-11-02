package strcturedPatterns.adapterPattern.problem;

import strcturedPatterns.adapterPattern.problem.concreteClass.PayU;
import strcturedPatterns.adapterPattern.problem.service.CheckoutService;


/*
    Structural Pattern - Focuses on how class and objects structured to form larger components.
    What is the problem here everything is fine right?
    The problem comes when we move to other third party.

    So what Adapter pattern tells is had an adapter class and make it to implements the interface and made the class to adapt it.
*/

public class Main {
    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService(new PayU());
        checkoutService.checkout("ID1837Xhd480",104875.80);
    }
}
