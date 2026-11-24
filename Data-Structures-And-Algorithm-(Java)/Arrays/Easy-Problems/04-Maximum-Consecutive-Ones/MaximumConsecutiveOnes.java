import java.util.Scanner;
public class MaximumConsecutiveOnes{

    static int consecutiveOnes(int [] array){
        int howManyOnesWeSee = 0;
        int howMayConsecutiveOnes =  0;

        for(int val : array){
            if(val == 1){
                howManyOnesWeSee++;
                howMayConsecutiveOnes = Math.max(howManyOnesWeSee,howMayConsecutiveOnes);
            }else{
                howManyOnesWeSee = 0;
            }
        }

        return howMayConsecutiveOnes;

    }


    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
       System.out.println(consecutiveOnes(array));
    }
}