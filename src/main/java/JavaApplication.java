import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = input.nextLine();

        if (text == null || text.isEmpty()) {
            System.out.println("Text is not correct");
        }

        String[] words = text.split(" ");
    }
}
