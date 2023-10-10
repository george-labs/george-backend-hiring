package wordcounter.reader;

import wordcounter.WordReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + fileName))) {
            String line = reader.readLine();

            while (line != null) {
                stopWords.add(line);
                line = reader.readLine();
            }
            return String.join(" ", stopWords);
        }catch (FileNotFoundException e) {
            System.err.println("File not found. Please provide a string in the console.");
            return "";
        }
        catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
