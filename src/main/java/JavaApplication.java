import utilities.WordCounter;

import java.util.Scanner;

import static utilities.Constants.ENTER_TEXT;
import static utilities.Constants.NUMBER_OF_WORDS;

public class JavaApplication {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(ENTER_TEXT);
        String inputLine = scan.nextLine();
        System.out.println(NUMBER_OF_WORDS + WordCounter.countWords(inputLine));
    }

}
