import java.util.Scanner;

// Input for every primitive data type
public class ScannerAllTypes {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("byte  : ");  byte   b  = input.nextByte();
        System.out.print("short : ");  short  sh = input.nextShort();
        System.out.print("int   : ");  int    i  = input.nextInt();
        System.out.print("long  : ");  long   l  = input.nextLong();
        System.out.print("float : ");  float  f  = input.nextFloat();
        System.out.print("double: ");  double d  = input.nextDouble();
        System.out.print("bool  : ");  boolean bo = input.nextBoolean();
        System.out.print("char  : ");  char   c  = input.next().charAt(0);

        System.out.println(b + " " + sh + " " + i + " " + l + " " + f + " " + d + " " + bo + " " + c);
        input.close();
    }
}
