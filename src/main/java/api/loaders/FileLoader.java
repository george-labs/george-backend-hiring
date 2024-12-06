package api.loaders;

import java.io.IOException;
import java.util.List;

public interface FileLoader {

    List<String> loadFile();

    List<String> loadFile(String args) throws IOException;
}