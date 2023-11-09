import textProcessing.ConsoleLineReader;
import textProcessing.LineProcessor;
import textProcessing.LineReader;

import java.util.Scanner;

public class JavaApplication {

    static public void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LineReader lineReader = new ConsoleLineReader(scanner);
        LineProcessor lineProcessor = new LineProcessor();

        String line = lineReader.getLine();
        System.out.print(lineProcessor.getWords(line));


    }
}
