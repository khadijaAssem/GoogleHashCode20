import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {
    public static ArrayList<String[]> read(String path) throws FileNotFoundException {
        File myObj = new File(path);
        Scanner myReader = new Scanner(myObj);
        ArrayList<String[]> output = new ArrayList<String[]>();
        while (myReader.hasNextLine()) {
            String[] data = new String[1];
            data[0] = myReader.nextLine();
            output.add(data);
        }
        myReader.close();
//        System.out.println("File read successfully");
        return output;
    }
}