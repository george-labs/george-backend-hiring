import input.InputReadException;
import input.InputReader;
import input.InputSourceCloseException;
import reporter.ResultReporter;
import reporter.SimpleStringReporter;
import wordcounter.WordCounter;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class WordCounterApp {
    private static final String INPUT_PROMPT_MESSAGE = "Enter text: ";

    InputReader inputReader;
    WordCounter wordCounter;
    ResultReporter resultReporter;

    public WordCounterApp(InputReader inputReader, String stopWordsFileName) {
        this.inputReader = inputReader;
        this.wordCounter = new WordCounter(getStopWords(stopWordsFileName));
        this.resultReporter = new ResultReporter(new SimpleStringReporter());
    }

    public String run() {
        System.out.print(INPUT_PROMPT_MESSAGE);
        String inputLine = inputReader.getInput();
        int wordCount = wordCounter.countWords(inputLine);
        return resultReporter.report(wordCount);
    }

    public void shutDown() {
        try {
            inputReader.closeInputSource();
        } catch (IOException e) {
            throw new InputSourceCloseException("Could not close the input source");
        }
    }

    private Set<String> getStopWords(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        return readFromInputStream(inputStream);
    }

    private Set<String> readFromInputStream(InputStream inputStream) {
        Set<String> stopWords = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                stopWords.add(line);
            }
            return stopWords;
        } catch (IOException e) {
            throw new InputReadException("Error when reading the file");
        }

    }
}
