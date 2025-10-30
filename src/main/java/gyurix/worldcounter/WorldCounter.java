package gyurix.worldcounter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

public class WorldCounter {
    private Set<String> stopWords = new HashSet<>();
    private String input;
    private int result;
    private boolean complete;

    public WorldCounter() {
    }

    public WorldCounter(String stopwordsPath) throws IOException {
        if (stopwordsPath == null) {
            throw new NullPointerException("stopwordsPath is null");
        }
        loadStopWords(stopwordsPath);
    }

    private void loadStopWords(String stopwordsPath) throws IOException {
        stopWords = new HashSet<>();
        Files.readAllLines(new File(stopwordsPath).toPath()).forEach(line -> stopWords.add(line.trim().toLowerCase()));
    }

    public void setInput(String input) {
        this.complete = false;
        this.result = 0;
        if (input == null || !input.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Invalid input, only a-z, A-Z and spaces are allowed");
        }
        this.input = input;
    }

    public void doWork() {
        if (complete) {
            throw new IllegalStateException("Work is already complete");
        }
        if (input == null) {
            throw new NullPointerException("Input is null");
        }
        for (String word : input.split(" ")) {
            if (!stopWords.contains(word.toLowerCase())) {
                ++result;
            }
        }
        this.complete = true;
    }

    public int getResult() {
        if (!complete) {
            throw new IllegalStateException("Result is not complete");
        }
        return result;
    }
}
