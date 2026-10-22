package user_defined_exceptions;

// This is how we create our custom exception.
public class UserDefinedException extends Exception{
    String message;
    public  UserDefinedException(String message){
        super(message);
    }
}
