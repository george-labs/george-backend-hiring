import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter text: ");
        Scanner in = new Scanner(System.in);

        Sentence sentence = new Sentence();
        String inputSentence = in.nextLine();

        System.out.println("Number of words: " + sentence.countingWordsOnlyLetter(inputSentence));
    }
}
