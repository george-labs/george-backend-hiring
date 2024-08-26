import kotlin.text.Regex;

import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        System.out.println("Enter text: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        var regex = new Regex("[a-zA-Z]*");
        var words = input.split("\\s+");


        scanner.close();
    }

}
