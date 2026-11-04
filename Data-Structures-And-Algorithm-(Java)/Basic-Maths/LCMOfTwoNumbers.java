import java.util.Scanner;

public class LCMOfTwoNumbers{
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

    static int lcm(int num1,int num2){
        int result = num1 * num2/gcd(num1,num2);
        return result;
    }

    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int lcmOfNumbers = lcm(num1,num2);
        System.out.println("The LCM of "+num1+" and "+num2+" are : "+lcmOfNumbers);
    }
}