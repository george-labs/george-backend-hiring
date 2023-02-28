package wordcount.inputreader;

import java.util.Scanner;

public class ConsoleInputReader implements wordcount.InputReader {

    @Override
    public String readInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }
}
