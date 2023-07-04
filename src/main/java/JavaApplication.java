import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Sentence sentence = new Sentence();
        String inputSentence = in.nextLine();
        System.out.println("Number of words:" + sentence.countingWordsOnlyLetter(inputSentence));
    }
}
