import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter text:");

        String userName = myObj.nextLine();  // Read user input
        System.out.println("My text: " + userName);  // Output user input

    }
}
