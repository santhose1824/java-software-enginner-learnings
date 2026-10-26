package bufferWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;

// BufferReader is a character Stream subclass.
public class BufferWriterExample {
    public static void main(String[] args){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/bufferWriter/notes.txt",true))) {
            // It gives new line
            bufferedWriter.newLine();
            // This will add after the new line.
            bufferedWriter.write("This is a appended text");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
