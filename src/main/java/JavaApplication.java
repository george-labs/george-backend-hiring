import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaApplication {


    public static void main(String... args) {
        System.out.print("Enter text: ");
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        sc.close();

        int wordsWithoutSpecialCharactersCounter = countWords(inputString, "[a-zA-Z]+");

        System.out.println("Number of words: " + wordsWithoutSpecialCharactersCounter);
    }

    private static int countWords(String inputString, String regex) {
        Pattern pattern = Pattern.compile(regex);
        String[] inputWords = inputString.split(" ");
        int wordsWithoutSpecialCharactersCounter = 0;
        for (String word : inputWords) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                wordsWithoutSpecialCharactersCounter++;
            }
        }
        return wordsWithoutSpecialCharactersCounter;
    }
}
