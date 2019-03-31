package xyz.randomwords.app.entites;

public class RequestObject {

    private int wordLength;
    private String beginningWith;

    private static int MIN_LEN = 3;
    private static int MAX_LEN = 7;

    public RequestObject() {

        wordLength = MIN_LEN + (int)(Math.random() * ((MAX_LEN - MIN_LEN + 2) + 1));
        if( wordLength > MAX_LEN )
            wordLength = 5;
        beginningWith = "";
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public String getBeginningWith() {
        return beginningWith;
    }

    public void setBeginningWith(String beginningWith) {
        this.beginningWith = beginningWith;
    }
}
