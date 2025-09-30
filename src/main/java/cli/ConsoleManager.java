package cli;

public interface ConsoleManager {

    String printTextPromptAndReadInput();

    void printNumberOfWords(final long num);

    String printFileNamePromptAndReadInput();
}
