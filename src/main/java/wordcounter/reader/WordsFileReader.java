package wordcounter.reader;

import wordcounter.WordReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordsFileReader implements WordReader {
    private final String fileName;

    public WordsFileReader(String fileName) {
        this.fileName = fileName;
    }

    public String readWords() {
        List<String> stopWords = new ArrayList<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("src/main/resources/" + fileName));
            String line = reader.readLine();

            while (line != null) {
                stopWords.add(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.join(" ", stopWords);
    }
}
