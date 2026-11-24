import java.util.Scanner;

public class LCMOfTwoNumbers{
    static long gcd(long num1,long num2){
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

    static long lcm(long num1,long num2){
        long result = num1/gcd(num1,num2) * num2;
        return result;
    }

    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        long num1 = input.nextLong();
        long num2 = input.nextLong();
        long lcmOfNumbers = lcm(num1,num2);
        System.out.println("The LCM of "+num1+" and "+num2+" are : "+lcmOfNumbers);
    }
}