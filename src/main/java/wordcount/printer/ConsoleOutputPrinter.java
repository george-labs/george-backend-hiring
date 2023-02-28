package wordcount.printer;

import wordcount.OutputPrinter;

public class ConsoleOutputPrinter implements OutputPrinter {

    @Override
    public void print(String text) {
        System.out.print(text);
    }
}
