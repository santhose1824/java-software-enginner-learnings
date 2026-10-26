package inputStreamReader;

import java.io.IOException;
import java.io.InputStreamReader;

// Converts teh ByteStream into Character Stream.
public class InputReaderExample {
    public static void main(String[] args) {
        // Whenever we use Reade/Writter/Or any Stream use try catch
        try(InputStreamReader isr = new InputStreamReader(System.in)) {
            System.out.print("Enter some letters : ");
            // get the input via input stream reader
            // read always return int
            int input = isr.read();
            // check if it is ready or close
            while(isr.ready()) {
                // convert each numbers into character.
                System.out.println((char)input);
                input = isr.read();
            }
            // close the stream
            isr.close();
            System.out.println();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
