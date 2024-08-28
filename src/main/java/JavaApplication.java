
public class JavaApplication {
    public static void main(String[] args) {
        WordCounter w = new WordCounterImpl();
        System.out.println("Number of words: "+ w.countWords());
    }
}
