package providers;

public class WordsPrinter implements IWordsPrinter {
    private final ICustomPrinter customPrinter;

    public WordsPrinter(ICustomPrinter customPrinter) {
        this.customPrinter = customPrinter;
    }

    public void enterText() {
        customPrinter.print("Enter text: ");
    }

    public void result(int numberOfWords) {
        customPrinter.print("Number of words: " + numberOfWords);
    }
}
