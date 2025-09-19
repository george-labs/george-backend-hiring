import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Assumption
 * one-line input only
 *
 * input handling not tested
 */
public class JavaApplication {

    public static void main(String... args) {
        // "wor3d word" = per regex in description will be split to wor, d, word

        System.out.println("Enter text:");
        Scanner scan = new Scanner(System.in);

        System.out.println("Number of words:" + countWords(scan.nextLine()));
    }

    public static int countWords(String input) {
        int count = 0;
        String[] splice = input.split("[^a-zA-Z]+");
        if (splice.length == 1 && splice[0].equals("")) {
            count = 0;
        } else {
            count += splice.length;
        }
        return count;

    }

}
