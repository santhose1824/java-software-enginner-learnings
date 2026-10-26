package file;

import java.io.*;

public class FileClassExample {
    public static void main(String[] args) {
        // create a new file.
        try {
            File file = new File("src/file/new-text-file.txt");
            file.createNewFile();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // write in the file
        try (BufferedWriter br = new BufferedWriter(new FileWriter("src/file/new-text-file.txt"))) {
                br.write("I am writing into this file");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // read the file
        try (BufferedReader br = new BufferedReader(new FileReader("src/file/new-text-file.txt"))) {
            int ch = br.read();
            while(br.ready()){
                System.out.print((char)ch);
                ch = br.read();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // Delete the file.
        try {
            File file = new File("src/file/new-text-file-2.txt");
            file.createNewFile();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        try {
            File file = new File("src/file/new-text-file-2.txt");
            // delete the file and return boolean.
            if(file.delete()){
                System.out.println();
                // get the file name of current file object.
                System.out.println(file.getName() + " is deleted.");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
