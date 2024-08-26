import kotlin.text.Regex;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordCounter {

    private final Regex regexWord = new Regex("[a-zA-Z]+[\\.!\\?,]?");
    private int counter = 0;
    private final String input;
    private final List<String> stopWords = new ArrayList<>();

    public WordCounter(String input) {
        this.input = input;

        try {
            readStopwords();
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't read the stopwords file:\n" + e.getMessage());
        }
    }

    public void processString() {
        var tokens = Arrays.asList(input.split("\\s+"));

        tokens.forEach(word -> {
            if (stopWords.contains(word)) {
                return;
            }

            if (regexWord.matches(word)) {
                raiseCounter();
            }
        });
    }

    public int getWordCount() {
        return this.counter;
    }

    private void raiseCounter() {
        this.counter = this.counter + 1;
    }

    private void readStopwords() throws FileNotFoundException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("stopwords.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                this.stopWords.add(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
