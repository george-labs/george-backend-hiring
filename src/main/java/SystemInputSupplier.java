import java.util.Scanner;

public class SystemInputSupplier implements InputSupplier {

    public String read() {
        String in = null;
        try (Scanner scanner = new Scanner(System.in)) {
            in = scanner.nextLine();
            if (in.isEmpty()) {
                System.out.println("not a valid string");
                System.exit(-1);
            }
        }
        return in;
    }
}
