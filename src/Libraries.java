import javafx.util.Pair;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Libraries {
    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<Object> getLibraries() throws FileNotFoundException {
        ArrayList<String[]> output = ReadFile.read("a_example.txt");
        for (int i=0;i<output.size();i++){
            output.set(i,output.get(i)[0].split(" +"));
        }

        for (int i=0;i<output.get(1).length;i++) {
            Book b = new Book();
            b.setId(i);
            b.setUsed(false);
            b.setScore(Integer.parseInt(output.get(1)[i]));
            books.add(b);
        }

        int size = Integer.parseInt(output.get(0)[1]);
        Library[] libraries = new Library[size];
        int li = 0;
        for (int i=2;i<output.size();i+=2) {
            Book[] B = new Book[Integer.parseInt(output.get(i)[0])];
            for (int j=0;j<output.get(i+1).length;j++)
                B[j] = books.get(Integer.parseInt(output.get(i+1)[j]));
            B = sortBooks(B);
            libraries[li] = new Library(Integer.parseInt(output.get(i)[2]),Integer.parseInt(output.get(i)[1]),B);

            Book [] booksIds;
            int sum=0;
            booksIds = libraries[li].getBooks();
            for(int j=0;j<booksIds.length;j++){
                sum+= books.get(booksIds[j].getId()).getScore();
            }
            libraries[li].setLibraryIndex(li);
            libraries[li].setSum(sum);
            li++;
        }
        ArrayList<Object> pair = new ArrayList<>();
        pair.add(libraries);
        pair.add(Integer.parseInt(output.get(0)[2]));
        return pair;
    }
    public static Book[] sortBooks(Book[] boks){
        for(int i=0;i<boks.length;i++){
            for(int j=i+1;j<boks.length;j++){
                if (books.get(boks[i].getId()).getScore()<books.get(boks[j].getId()).getScore()){
                    Book temp = boks[i];
                    boks[i] = boks[j];
                    boks[j] = temp;
                }
            }
        }
        return boks;
    }
}
