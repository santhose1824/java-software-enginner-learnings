import java.util.Scanner;

public class MajortyElementI{
    static int marjorityElement(int [] array){
        int votingCount = 0;
        int candidate = 0;

        for(int i = 0; i < array.length; i++){
            if(votingCount == 0){
                votingCount = 1;
                candidate = array[i];
            }else if(array[i] == candidate){
                votingCount++;
            }else{
                votingCount--;
            }
        }

        int count = 0;
        int n = array.length;
        for(int i = 0; i < array.length; i++){
            if(candidate == array[i]){
                count++;
            }
        }

        return count >= n/2 ? candidate : -1;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int sizeOne = input.nextInt();
        int [] arrayOne = new int[sizeOne];
        for(int i = 0; i < sizeOne; i++){
            arrayOne[i] = input.nextInt();
        }
       System.out.println(marjorityElement(arrayOne));
    }
}