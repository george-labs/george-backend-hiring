import java.util.Scanner;

public class ScannerUtil {

    public static String scanText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        return scanner.nextLine();
    }
}
