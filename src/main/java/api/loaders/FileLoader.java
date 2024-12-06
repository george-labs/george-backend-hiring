package api.loaders;

import java.util.List;

public interface FileLoader {

    List<String> loadFile();

    List<String> loadFile(String args);
}