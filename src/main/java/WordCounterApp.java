import input.ConsoleScanner;
import input.InputReadException;
import input.InputReader;
import reporter.ResultReporter;
import reporter.SimpleStringReporter;
import wordcounter.WordCounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCounterApp {


    InputReader inputReader;
    WordCounter wordCounter;
    ResultReporter resultReporter;

    public WordCounterApp(String filename) {
        this.inputReader = new InputReader(new ConsoleScanner(new Scanner(System.in)));
        this.wordCounter = new WordCounter(getStopWords(filename));
        this.resultReporter = new ResultReporter(new SimpleStringReporter());
    }

    public String run(){
        String inputLine = inputReader.getInput();
        int wordCount = wordCounter.countWords(inputLine);
        return resultReporter.report(wordCount);
    }

    private Set<String> getStopWords(String fileName){
        Set<String> stopWords = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String word;
            while ((word = br.readLine()) != null) {
                System.out.println(word);
                stopWords.add(word);
            }
            return stopWords;
        } catch (IOException e) {
            e.printStackTrace();
            throw new InputReadException("Error when reading the file");
        }
    }

}
