package wordFilter;

public class AlphabeticWordFilter implements WordFilter{

    public boolean isWord(String word) {
         return word.matches("[a-zA-Z]+");
    }
}
