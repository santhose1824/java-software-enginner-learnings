package fileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

// File Reader - reads every character from the given file. - Character Stream
public class FileReaderExample {
    public static void main(String[] args) {
        // Always give the reference path of the file.
        // Try catch block will automatically close  the reader.
        try(FileReader fileReader = new FileReader("src/fileReader/notes.txt")){
            // reads the every character from the file.
            // read always return int
            int ch = fileReader.read();
            // check if the reader is close or not.
            while(fileReader.ready()){
                System.out.print((char)ch);
                // continuously reads until the reader is closed
                ch = fileReader.read();
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
