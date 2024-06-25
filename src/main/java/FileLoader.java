import java.io.InputStream;

public class FileLoader {

    public String loadFile(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        return new InputProcessor(inputStream).readInput();
    }
}
