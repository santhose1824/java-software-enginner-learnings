import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class LeaderOfAnArray{

    static List<Integer> leaderOfArray(int [] array){
        List<Integer> leaderList = new ArrayList();
        if(array.length == 0){
            return leaderList;
        }
        int max = array[array.length-1];
        leaderList.add(max);

        for(int i = array.length-1; i >=0; i--){
            if(array[i] > max){
                leaderList.add(array[i]);
                max = array[i];
            }
        }

        int start = 0;
        int end = leaderList.size()-1;

        while(start < end){
            int temp = leaderList.get(start);
            leaderList.set(start,leaderList.get(end));
            leaderList.set(end,temp);

            start++;
            end--;
        }

        return leaderList;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int sizeOne = input.nextInt();
        int [] arrayOne = new int[sizeOne];
        for(int i = 0; i < sizeOne; i++){
            arrayOne[i] = input.nextInt();
        }
       System.out.println(leaderOfArray(arrayOne));
    }
}