import java.io.FileNotFoundException;

public class JavaApplication {
    public static void main(String[] args) throws FileNotFoundException {

        final ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        final FileInputReader fileInputReader = new FileInputReader();
        final ConsoleOutputWriter consoleOutputWriter = new ConsoleOutputWriter();
        final FileStopWordsReader fileStopWordsReader = new FileStopWordsReader();

        execute(consoleOutputWriter, consoleInputReader, fileInputReader, fileStopWordsReader, args);
    }

    static void execute(OutputWriter outputWriter, InputReader inputReader, InputReader fileInputReader, StopWordsReader stopWordsReader,
                        String[] args) {

        final WordCounter wordCounter = new WordCounter(stopWordsReader.readStopWords());

        final String line;
        if (args.length > 0) {
            String inputFilename = args[0];
            line = fileInputReader.readInput(inputFilename);
        } else {
            final String queryString = "Enter text: ";
            outputWriter.writeOutput(queryString);
            line = inputReader.readInput(null);
        }

        long count = wordCounter.getWordCount(line);
        String outputMessageFormat = "Number of words: %d";
        outputWriter.writeOutput(String.format(outputMessageFormat, count));

    }
}
