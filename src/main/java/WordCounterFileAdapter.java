import kotlin.text.Regex;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounterFileAdapter {
    private WordCounter wordCounter;

    public WordCounterFileAdapter(String fileName, List<String> stopWords) {
        try(BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constraints.RESOURCES_PATH + fileName)))) {
            String lines = fileReader.lines().collect(Collectors.joining(" "));
            this.wordCounter = new WordCounter(new Regex("[A-Za-z]+"), stopWords, lines);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
