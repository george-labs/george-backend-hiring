import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Assumption
 */
public class JavaApplication {

    public static void main(String... args) {
        // "wor3d word" = per regex in description will be split to wor, d, word

        System.out.println("Enter text:");
        Pattern pattern = Pattern.compile("^[a-zA-z]*");
        Scanner scan = new Scanner(System.in);
        int count = 0;

        try {
            while (true) {
                String text = scan.next(); // wor3d

                String[] splice = text.split("^[a-zA-Z]*");
                count += splice.length;
            }
        } catch (NoSuchElementException e) {
            // no action needed -just end the method
        }
        System.out.println("Number of words:" + count);
    }




}
