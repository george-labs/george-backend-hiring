package cli;

import java.util.Scanner;

import static utils.Constants.*;

public class ConsoleManagerImpl implements ConsoleManager {

    private final static Scanner SCANNER = new Scanner(System.in);

    @Override
    public String printTextPromptAndReadInput() {
        System.out.print(ENTER_TEXT_MSG);
        return SCANNER.nextLine();
    }

    @Override
    public void printNumberOfWords(final long num) {
        System.out.printf(NUMBER_OF_WORDS_MSG, num);
    }

    @Override
    public String printFileNamePromptAndReadInput() {
        System.out.print(ENTER_FILE_NAME_MSG);
        return SCANNER.nextLine();
    }
}
