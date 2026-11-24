package behaviourPatterns.chainOfResponsibilityPattern.problem;


/*
    In a customer support system for and e-commerce platform users raise tickets, These tickets could be
    General Queries
    Refund Requests
    Technical issues
    Complaints about delivery


    If we put everything in a same class and method
    It violates open close principle.
    Everytime new type is added the class or method must be edited.
    All logic is in single class
    Not flexible or scalable : Cannot change the order of processing without modifying core logic
*/


public class Main {
    public static void main(String[] args) {
        SupportService supportService = new SupportService();

        supportService.handleRequest("general");
        supportService.handleRequest("refund");
        supportService.handleRequest("technical");
        supportService.handleRequest("delivery");
        supportService.handleRequest("something");
    }
}
