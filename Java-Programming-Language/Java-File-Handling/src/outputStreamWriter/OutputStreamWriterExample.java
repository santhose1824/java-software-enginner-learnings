package outputStreamWriter;

import java.io.FileWriter;
import java.io. OutputStreamWriter;

// OutputStreamWriter is from Character Stream.
public class OutputStreamWriterExample {
    public static void main(String[] args) {
        try(OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out)) {
           // Mostly used to write the output.
           // The write method is overloading so it will print based on the parameter.
           outputStreamWriter.write("Hello World");
           outputStreamWriter.write("\n");
           outputStreamWriter.write("This is a test");
           outputStreamWriter.write("\n");
           outputStreamWriter.write('A');
            outputStreamWriter.write("\n");
           outputStreamWriter.write('B');
            outputStreamWriter.write("\n");
           char [] arr = "My name is H.M.Santhose".toCharArray();
           outputStreamWriter.write(arr);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        // FileWriter
        try(FileWriter fileWriter = new FileWriter("src/outputStreamWriter/notes.txt",true);){
            // This will override the content in the file.
            fileWriter.write("This is a appended text");
            // If you don't want to override just add true after the file name
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
