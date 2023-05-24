import kotlin.text.Regex;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounterFileAdapter implements Counter {
    private final Counter counter;

    public WordCounterFileAdapter(String fileName, List<String> stopWords, String regexString) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constraints.RESOURCES_PATH + fileName)))) {
            String lines = fileReader.lines().collect(Collectors.joining(" "));
            this.counter = new WordCounter(new Regex(regexString), stopWords, lines);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer count() {
        if (this.counter == null) {
            throw new RuntimeException("No WordCounter instance provided");
        }
        return this.counter.count();
    }

    @Override
    public Integer unique() {
        return this.counter.unique();
    }

    @Override
    public Stream<String> filteredLine() {
        return this.counter.filteredLine();
    }

    @Override
    public void display() {
        this.counter.display();
    }
}
