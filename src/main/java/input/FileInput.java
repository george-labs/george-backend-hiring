package input;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileInput implements Input{
    private final String path;
    public FileInput(String path) throws IOException{
        this.path = path;
        var file = new File(path);
        if(!file.exists()){
            throw new FileNotFoundException("Cannot find file: '" + path + "'");
        }
        //TODO: Exception if file can't access
    }
    @Override
    public String getString() {
        List<String> inputLines = null;
        try {
            inputLines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return String.join(" ", inputLines);
    }
}
