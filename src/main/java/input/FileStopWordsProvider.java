package input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileStopWordsProvider implements StopWordsProvider {

    @Override
    public Set<String> getStopWords(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        return new HashSet<>(lines);
    }

}
