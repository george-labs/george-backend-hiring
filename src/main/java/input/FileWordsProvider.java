package input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

public class FileWordsProvider implements WordsProvider {

    @Override
    public Collection<String> getWords(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        return lines;
    }

}
