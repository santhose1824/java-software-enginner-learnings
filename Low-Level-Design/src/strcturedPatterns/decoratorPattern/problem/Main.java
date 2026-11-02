package strcturedPatterns.decoratorPattern.problem;



/*
    Consider You want to develop a food delivery application.
    You allow the user to order Pizza, but there are varieties of Pizza right.
    So you create a class called Pizza end it extends the Types of Pizza right.

    But think of it you have so many combinations like below how many child class you can able to create
    That is impossible to do it right.
    Wait there might be a way you think of it with the previous pattern we learnt.
    Yes, we can think of Builder Pattern, but there is an issue in it,

    Let me explain. In builder class what we do is we take one main class and use builder class to use it 's optional.
    But here it is not optional, These are types (varieties) of classes.
    So that's were we are come up with Structural Pattern called Decorator Pattern.
*/

class PlainPizza{}
class  CheesePizza extends  PlainPizza{}
class  OlivePizza extends  PlainPizza{}
class  StuffedPizza extends  PlainPizza{}
class CheeseStuffedPizza extends  CheesePizza{}
class CheeseOlivePizza extends  CheesePizza{}
class CheeseStuffedOlivePizza extends  CheesePizza{}


public class Main {
    public static void main(String[] args) {

    }
}
