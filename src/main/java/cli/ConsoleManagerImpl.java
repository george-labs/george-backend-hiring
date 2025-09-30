package cli;

import java.util.Scanner;

import static utils.Constants.ENTER_TEXT_MSG;
import static utils.Constants.NUMBER_OF_WORDS_MSG;

public class ConsoleManagerImpl implements ConsoleManager {

    private final static Scanner SCANNER = new Scanner(System.in);

    @Override
    public String printPromptAndReadInput() {
        System.out.print(ENTER_TEXT_MSG);
        return SCANNER.nextLine();
    }

    @Override
    public void printNumberOfWords(final int num) {
        System.out.printf(NUMBER_OF_WORDS_MSG, num);
    }
}
