public class JavaApplication {


    public static void main(String[] args) {
        String read = WordCounter.readFromSystemIn();
        System.out.println("Number of Words:" + WordCounter.countWords(read));
    }
}
