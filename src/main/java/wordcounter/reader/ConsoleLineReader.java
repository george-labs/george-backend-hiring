package wordcounter.reader;

import wordcounter.WordReader;

import java.util.Scanner;

public class ConsoleLineReader implements WordReader {
    @Override
    public String readWords() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
