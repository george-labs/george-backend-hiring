import exception.WordCounterException;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public FileReader() {

    }

    public List<String> readWordsFromFile(String path) {
        List<String> words;

        Path p = Paths.get(path);

        try {
            words = Files.readAllLines(p);
        } catch (IOException e) {
            throw new WordCounterException("File could not be found at: " + path, e);
        }
        return words;
    }

    public String readFileFromArguments(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        Scanner reader = new Scanner(new FileInputStream(fileName));

        while (reader.hasNext()) {
            stringBuilder.append(" ").append(reader.nextLine());
        }

        return stringBuilder.toString();
    }
}
