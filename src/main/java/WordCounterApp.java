import input.InputReadException;
import input.InputReader;
import reporter.ResultReporter;
import reporter.SimpleStringReporter;
import wordcounter.WordCounter;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class WordCounterApp {


    InputReader inputReader;
    WordCounter wordCounter;
    ResultReporter resultReporter;

    public WordCounterApp(InputReader inputReader, String stopWordsFileName) {
        this.inputReader = inputReader;
        this.wordCounter = new WordCounter(getStopWords(stopWordsFileName));
        this.resultReporter = new ResultReporter(new SimpleStringReporter());
    }

    public String run() {
        String inputLine = inputReader.getInput();
        int wordCount = wordCounter.countWords(inputLine);
        return resultReporter.report(wordCount);
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
