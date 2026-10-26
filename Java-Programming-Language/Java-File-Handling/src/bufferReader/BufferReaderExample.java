package bufferReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

// BufferReader is a character Stream subclass.
public class BufferReaderExample {
    public static void main(String[] args) {
       // BufferReader with InputStreamReader.
       try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
           System.out.println("Enter whatever you want : ");
           // to read a entire line as input.
           // readLine() always returns string.
           String input = bufferedReader.readLine();
           System.out.println("The line you typed is : "+input);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }


        // BufferReader with FileReader.
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/bufferReader/notes.txt"))){
            // Check whether the buffer is ready are not
            while(bufferedReader.ready()){
                // This will read the entire file content as a String and the print it .
                String fileContent = bufferedReader.readLine();
                System.out.println("The content in the file is:");
                System.out.println(fileContent);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
