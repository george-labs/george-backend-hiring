import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        WordValidator validator = new EuropeanWordValidator();
        WordCounter counter = new OneSpaceWordCounter(validator);
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        System.out.println(counter.countWords(s));
    }
}
