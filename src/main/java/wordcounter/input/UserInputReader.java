package wordcounter.input;

import java.util.Scanner;

public class UserInputReader implements InputReader {

    @Override
    public String readInput() {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
