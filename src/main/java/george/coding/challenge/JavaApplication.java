package george.coding.challenge;

import george.coding.challenge.job.WordCountParser;
import george.coding.challenge.printer.ConsolePrinter;
import george.coding.challenge.reader.ConsoleReader;

public class JavaApplication {
    public static void main(String[] args) {
        var reader = new ConsoleReader();
        var wordCountParser = new WordCountParser();
        var printer = new ConsolePrinter();

        var readText = reader.read();
        var result = wordCountParser.parse(readText);

        printer.print(result);
        reader.close();
    }
}
