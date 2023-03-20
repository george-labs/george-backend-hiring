import java.util.Scanner;

public class JavaApplication {

    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter text: ");
        String sentence = reader.nextLine();
        reader.close();
        System.out.println("Number of words: " + WordCounter.countWords(sentence));
    }
}
