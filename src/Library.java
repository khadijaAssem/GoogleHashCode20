import java.math.BigInteger;
import java.util.ArrayList;

public class Library {
    private Book[] books;
    private int BPD = new Integer(0);
    private int signUp = new Integer(0);
    private int sum;
    private boolean signedUp = false;
    private int gotBooks = 0;
    private ArrayList<Integer> usedBooks = new ArrayList<>();
    private int LibraryIndex;
    private int nBook = 0;
    private BigInteger numberOfScannedBooks;
    private int BTS;
    private int signedIn;

    public Library(int BPD,int signUp,Book[] books){

        this.books = books;
        this.BPD = BPD;
        this.signUp = signUp;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getBPD() {
        return BPD;
    }

    public void setBPD(int BPD) {
        this.BPD = BPD;
    }

    public int getSignUp() {
        return signUp;
    }

    public void setSignUp(int signUp) {
        this.signUp = signUp;
    }

    public void printLib(){
        System.out.println("BPD "+BPD);
        System.out.println("sign up "+signUp);
        System.out.println("Sum "+sum);
        System.out.println("BOOKS");
        for (int i =0;i<books.length;i++)
            System.out.println(books[i]);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public boolean isSignedUp() {
        return signedUp;
    }

    public void setSignedUp(boolean signedUp) {
        this.signedUp = signedUp;
    }

    public int getGotBooks() {
        return gotBooks;
    }

    public ArrayList<Integer> getUsedBooks() {
        return usedBooks;
    }

    public int getLibraryIndex() {
        return LibraryIndex;
    }

    public void setLibraryIndex(int libraryIndex) {
        LibraryIndex = libraryIndex;
    }

    public Book getNextBook() throws Exception {
        try {
            return books[nBook++];
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public BigInteger  getNumberOfScannedBooks() {
        return numberOfScannedBooks;
    }

    public void setNumberOfScannedBooks(BigInteger  numberOfScannedBooks) {
        this.numberOfScannedBooks = numberOfScannedBooks;
    }

    public int getBTS() {
        return BTS;
    }

    public void setBTS(int BTS) {
        this.BTS = BTS;
    }

    public int getSignedIn() {
        return signedIn;
    }

    public void setSignedIn(int signedIn) {
        this.signedIn = signedIn;
    }
}
