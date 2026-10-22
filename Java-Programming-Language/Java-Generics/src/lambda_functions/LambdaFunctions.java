package lambda_functions;

import java.util.ArrayList;
import java.util.Arrays;

public class LambdaFunctions {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i <= 10; i++){
            list.add(i);
        }

        list.forEach((item)-> System.out.print(item*2+" "));
        System.out.println();

        int[] sum = { 0 };

         list.forEach((item)->sum[0]+=item);


        System.out.println(Arrays.toString(sum));


        Operation add = (a,b)->a+b;
        Operation sub = (a,b)->a-b;
        Operation mul = (a,b)->a*b;

        LambdaFunctions lambdaFunctions = new LambdaFunctions();
        System.out.println(lambdaFunctions.operate(3,4,add));
        System.out.println(lambdaFunctions.operate(3,4,sub));
        System.out.println(lambdaFunctions.operate(3,4,mul));
    }

    private int operate(int a,int b,Operation operation){
        return operation.operations(a,b);
    }
}


interface Operation{
    int operations(int a,int b);
}

