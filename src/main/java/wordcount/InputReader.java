package wordcount;

import java.util.Scanner;

public class InputReader {
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        return scanner.nextLine();
    }
}
