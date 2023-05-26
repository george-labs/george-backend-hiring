import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileProcessor {

    public List<String> getListOfLinesFromFile(String fileName){
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            System.err.println("Exception while processing/opening the file. Message: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }





}
