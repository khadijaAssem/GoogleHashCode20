public class Book {
    private boolean isUsed;
    private int id;
    private int score;
    private int usedInLibrary;

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getUsedInLibrary() {
        return usedInLibrary;
    }

    public void setUsedInLibrary(int usedInLibrary) {
        this.usedInLibrary = usedInLibrary;
    }
}
