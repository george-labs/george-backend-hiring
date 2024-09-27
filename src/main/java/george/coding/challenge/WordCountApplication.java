package george.coding.challenge;

import george.coding.challenge.job.WordCountParser;
import george.coding.challenge.printer.ConsolePrinter;
import george.coding.challenge.reader.ConsoleReader;
import george.coding.challenge.reader.FileReader;
import george.coding.challenge.reader.TextReader;

import java.io.IOException;

public class WordCountApplication {
    public static void main(String[] args) throws IOException {
        TextReader reader = args.length == 0 ? new ConsoleReader() : new FileReader(args[0]);

        var wordCountParser = new WordCountParser();
        var printer = new ConsolePrinter();

        var readText = reader.read();
        var result = wordCountParser.parse(readText);

        printer.print(result);
        reader.close();
    }
}
