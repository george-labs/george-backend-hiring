import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaApplication {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();

        var words = text.split("[\\s]");
        Pattern pattern = Pattern.compile("[a-zA-Z]");


        long counter = 0;
        for(String word: words){
            Matcher matcher = pattern.matcher(word);
            if(matcher.matches()){
                counter ++;
            }
        }

        System.out.println(counter);

        //
    }
}
