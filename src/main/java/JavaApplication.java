import wordcount.WordCount;

public class JavaApplication {
    public static void main(String[] args) {
        WordCount wordCount = new WordCount();
        System.out.println(wordCount.countWords("Mary had a little lamb."));
    }
}
