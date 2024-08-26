import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public static List<String> loadInputContent(String filename) throws IOException {
        if (!isFilePathCorrect(filename)) {
            throw new IOException(String.format("File '%s' not found", filename));
        }

        return loadLines(new FileInputStream(filename));
    }

    public static List<String> loadStopWords() throws IOException {
        return loadStopWords("stopwords.txt");
    }

    public static List<String> loadStopWords(String filename) throws IOException {
        var resourceInputStream = loadResource(filename);

        if (resourceInputStream == null) {
            throw new IOException(String.format("File '%s' not found", filename));
        }

        return loadLines(resourceInputStream);
    }

    private static List<String> loadLines(InputStream inputStream) throws IOException {
        var lines = new ArrayList<String>();
        var inputStreamReader = new InputStreamReader(inputStream);
        var bufferedReader = new BufferedReader(inputStreamReader);

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

        inputStreamReader.close();
        bufferedReader.close();

        return lines;
    }

    private static boolean isFilePathCorrect(String filePath) {
        var path = Paths.get(filePath);
        return Files.exists(path);
    }

    private static InputStream loadResource(String resourceName) {
        return FileLoader.class.getClassLoader().getResourceAsStream(resourceName);
    }

}
