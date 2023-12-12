import reader.FileReader;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Scanner;

public class JavaApplication {

    private final InputStream input;
    private final PrintStream output;


    public static void main(String args[]) {
        JavaApplication javaApplication = new JavaApplication(System.in, System.out);
        javaApplication.countWords(extractPathToFile(args));
    }

    private static String extractPathToFile(String[] args) {
        return args[0];
    }

    public void countWords(String pathToInputFile) {
        WordCounter wordCounter = new WordCounter();
        FileReader fileReader = new FileReader(pathToInputFile);
        Collection<String> input = fileReader.read();

        // TODO it is needed to deal with input that is divided into lines
        // we can either concat it into one sentence or adapt the WordCounter

        Scanner scannerInput = new Scanner(this.input);
        output.print("Enter the text: ");

        long wordsCount = wordCounter.count(scannerInput.nextLine());

        output.print("Number of words: " );
        output.print(wordsCount);
    }

    public JavaApplication(InputStream input, PrintStream output) {
        this.input = input;
        this.output = output;
    }
}
