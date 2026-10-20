package introduction_to_oops;

public class WrapperClasses {
    public static void main(String[] args) {
        // This is primitive type of Integer
        int a = 10;

        // This is the object type of integer.
        // We get many methods to access if we use num.
        Integer num = 10;

        // Here the swap is not gonna work because Java is pass by value.
        int numOne = 20;
        int numTwo = 40;

        swap(numOne, numTwo);
        System.out.println(numOne+ " "+numTwo);

        // Here the swap is not happens because the class is final eventhrough the values are treated as objects.
        Integer num1 = 30;
        Integer num2 = 50;

        swap(num1, num2);
        System.out.println(num1+ " "+num2);

        // For objects we can able to make change if it is final but only to the value not to the refernce variable
        final FinalKeyword finalKeyword = new FinalKeyword("Santhose");
        System.out.println(finalKeyword.name);
        finalKeyword.name = "Hayagreevan";
        System.out.println(finalKeyword.name);


        // this is not allowes
//        FinalKeyword finalKeyword1  = new FinalKeyword("Santhose");
//        finalKeyword = finalKeyword1


        FinalKeyword fn;
        for(int i = 0; i<1000000000; i++){
            fn = new FinalKeyword("Random name");
        }


    }

    static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    static void swapInteger(Integer num1, Integer num2){
        Integer temp = num1;
        num1 = num2;
        num2 = temp;
    }


}

class FinalKeyword{
    // final varaible cannot be changed and it must be like this
    final int FINAL_VARIABLE = 10;
    String name;

    public FinalKeyword(String name) {
        System.out.println("Object is created");
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destoryed and it shows this");
    }
}
