import java.util.Scanner;

public class GCDOfTwoNumbers{
    static int gcd(int num1,int num2){
        while(num1 != 0 && num2 != 0){
            if(num1 > num2){
                num1 = num1 % num2;
            }else{
                num2 = num2 % num1;
            }
        }

        if(num1 == 0){
            return num2;
        }
        return num1;
    }

    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int gcdOfNumbers = gcd(num1,num2);
        System.out.println("The GCD of "+num1+" and "+num2+" are : "+gcdOfNumbers);
    }
}