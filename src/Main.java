import javafx.util.Pair;

import javax.jws.soap.SOAPMessageHandlers;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static Library[] libraries;
    public static int days;
    public static int ind = 0;
    public static Map<Library,Integer> Sum = new LinkedHashMap();
//    public static Map<Integer, Integer> scannedBooks = new HashMap<>();
    public static int lastSigned;
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Object> pair = Libraries.getLibraries();
        libraries = (Library[]) pair.get(0);
        days = (int) pair.get(1);
        ArrayList<Library> signedUp = new ArrayList<>();
        int siggningDays = 0;
        Library signningup = null;
        boolean signning = false;
        for (int i = 0; i < libraries.length; i++) {
            Sum.put(libraries[i], libraries[i].getSum());
            Sum = sortByValue(Sum);
        }
        for (int day =0;day<days;day++){
//            System.out.println();
            System.out.println("Day : "+day);
            if (ind <= libraries.length || signning) {//Available libraries
//                System.out.println("Available Libraries : "+ (ind <= libraries.length) + " signing "+ signning);
                if(!signning) {//signing isn't busy
                    siggningDays = 0;
                    signningup = getNextLibrary();//get next library
                    signning = true;//set signing busy
//                    System.out.println("Begin signing the library + " + signningup.getLibraryIndex());
                }
                else{//signing busy
                    if (siggningDays < signningup.getSignUp()-1) {
//                        System.out.println("Signing the library + " + signningup.getLibraryIndex());
                        siggningDays++;
                    }
                    else {
                        BigInteger A = new BigInteger(String.valueOf(days));
                        BigInteger B = new BigInteger(String.valueOf(day));
                        BigInteger C = new BigInteger(String.valueOf(signningup.getBPD()));
                        BigInteger k =  (A.subtract(B)).multiply(C);
                        signningup.setNumberOfScannedBooks(k);
                        System.out.println(k);
                        BigInteger tCo = new BigInteger(String.valueOf(signningup.getBooks().length));
                        if (k.compareTo(tCo)>0){
                            signningup.setBTS(signningup.getBooks().length);
                        }
                        else {
                            signningup.setBTS(k.intValue());
                        }
                        signningup.setSignedIn(day);
                        lastSigned = day;
                        signedUp.add(signningup);
//                        System.out.println("Library "+signningup.getLibraryIndex()+" Signed Up");

                        siggningDays = 0;
                        try {
                            signningup = getNextLibrary();//get next library
                            signning = true;//set signing busy
//                            System.out.println("Begin signing the library + " + signningup.getLibraryIndex());
                        }
                        catch (Exception e){}
                    }
                }
            }
//            for (int lib = 0;lib<signedUp.size();lib++){
//                Library using = signedUp.get(lib);
//                for (int bok =0;bok<using.getBPD();bok++){
//                    try {
//                        int nextBook = using.getNextBook();
//                        if (!scannedBooks.containsKey(nextBook)){
//                            scannedBooks.put(nextBook, 1);
//                            using.getUsedBooks().add(nextBook);
//                        }
//                        else bok--;
//                    }
//                    catch (Exception e){}
//                }
//            }
        }

//        System.out.println("Output");
        String finalOutput = "";
        int noOfLibraries = signedUp.size();
        finalOutput.concat(String.valueOf(noOfLibraries));
        System.out.println(noOfLibraries);
        int m = 0;
        for (int i=0;i<noOfLibraries;i++){
            System.out.print(signedUp.get(i).getLibraryIndex()+ " ");
            int n = 0;
            String booooks = "";
            n=0;
            for (int j=0;j<signedUp.get(i).getBTS();j++) {
                ArrayList<Integer> us = new ArrayList<>();
                try {
                    Book b = signedUp.get(i).getNextBook();
                    while (b.isUsed()) {
                        b = signedUp.get(i).getNextBook();
                        us.add(b.getId());
                    }
                    booooks = booooks.concat(b.getId() + " ");
                    b.setUsedInLibrary(i);
                    b.setUsed(true);
                    n++;
                } catch (Exception e) {
//                    e.printStackTrace();
                }
                if (n==0){
                    n++;
                    booooks = booooks.concat(signedUp.get(i).getBooks()[0].getId() + " ");
                    m++;
                }
            }
            System.out.println(n);
            System.out.println(booooks);
//            int l=0;
//            for (int p=n;p<signedUp.get(i).getBTS();p++){
//                Book b = signedUp.get(i).getBooks()[l];
//                while (b.getUsedInLibrary()==i) {
//                    try {
//                        b = signedUp.get(i).getNextBook();
//                        l++;
//                    } catch (Exception e) {
////                        e.printStackTrace();
//                    }
//                }
//                System.out.print(b.getId() + " ");
//            }
//            System.out.println();
        }
//        for(int i=0;i<m;i++){
//
//        }
//        System.out.println(m);
//        System.out.println("Done");
    }
//    public static void allBooksUsed(Library li){
//        if (l)
//    }

    public static Library getNextLibrary(){
            Library li = (Library) Sum.keySet().toArray()[ind];
            ind++;
//            int count = 0;
//            for(int i=0;i<li.getBooks().length;i++){
//                if(scannedBooks.containsKey(li.getBooks()[i])){
//                    count++;
//                    continue;
//                }
//                else {
//                    return li;
//                }
//            }
//            if(count == li.getBooks().length)
//                getNextLibrary();
            return li;
    }

    public static HashMap<Library, Integer> sortByValue(Map<Library, Integer> hm) {
        List<Map.Entry<Library, Integer> > list =
                new LinkedList<Map.Entry<Library, Integer> >(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Library, Integer>>() {
            public int compare(Map.Entry<Library, Integer> o1,
                               Map.Entry<Library, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<Library, Integer> temp = new LinkedHashMap<Library, Integer>();
        for (Map.Entry<Library, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

}
