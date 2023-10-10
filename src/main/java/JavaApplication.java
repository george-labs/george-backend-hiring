import java.util.Arrays;
import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        WordValidator validator = new EuropeanWordValidator();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        System.out.println(Arrays.stream(s.split(" "))
                .filter(word -> validator.isValidWord(word))
                .count());
    }
}
