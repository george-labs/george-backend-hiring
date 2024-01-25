package io.eras;

import io.eras.parser.ClassPathInputFileParser;
import io.eras.parser.InputFileParser;
import io.eras.parser.InputParser;
import io.eras.supplier.InputSupplier;
import io.eras.supplier.SystemInputSupplier;
import io.eras.util.WordCounter;

import java.util.List;

public class JavaApplication {

    List<String> stopWords;

    public static void main(String[] args) {
        InputParser stopWordParser = new ClassPathInputFileParser("stopwords.txt");

        JavaApplication javaApplication = new JavaApplication();
        javaApplication.stopWords = stopWordParser.parse();

        WordCounter wordCounter = new WordCounter(javaApplication.stopWords);

        if (args.length == 1) {
            String filename = args[0];
            InputParser inputParser = new InputFileParser(filename);

            System.out.println("Number of Words:" + wordCounter.countWords(inputParser.parse()));
        } else {
            System.out.println("Enter text: ");
            InputSupplier inputSupplier = new SystemInputSupplier();

            System.out.println("Number of Words:" + wordCounter.countWords(inputSupplier.read()));
        }


    }
}
