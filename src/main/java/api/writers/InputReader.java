package api.writers;


import java.io.IOException;
import java.util.List;

public interface InputReader {

    List<String> readInput();

    List<String> readInput(String filePath) throws IOException;
}