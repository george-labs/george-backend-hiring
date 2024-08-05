package wordcounter;

import java.util.Scanner;

public class TextReader {

    public String readText() {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
