import java.util.Scanner;

public class JavaApplication {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter text: ");
        String textLine = scanner.nextLine();
        //System.out.println("You entered: " + textLine);

        System.out.println("Number of words: " + textLine.split(" ").length);
    }
}
