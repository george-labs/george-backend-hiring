import javax.swing.text.html.parser.Parser;
import java.util.Scanner;

public class JavaApplication {

    private static final WordParser parser = new SelectiveWordParser();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter text: ");
        String s = in.nextLine();

        int countWords = parser.countWords(s);


        System.out.println("Number of words: " + countWords);
    }


}
