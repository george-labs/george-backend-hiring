import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    static String loadInputFromFile(File file) {
        String content = null;
        try {
            content = Files.readString(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Error while reading file: '" + file.getName() + "'" + e);
            e.printStackTrace();
        }
        return content;
    }

    static List<String> loadFileByLines(File file) {
        List<String> lines = new ArrayList<>();
        if (file == null || !file.exists()) {
            System.out.println("File with excluded words not found! Filename: " + file.getName());
            return lines;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error while reading file: '" + file.getName() + "'" + e);
            e.printStackTrace();
        }
        return lines;
    }

    static File getFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) return null;
        File file = new File(fileName);
        if (!file.exists()) return null;
        return file;
    }

    static File getFileFromResources(String fileName) {
        if (fileName == null || fileName.isEmpty()) return null;
        File f = null;
        try {
            URL url = WordCounter.class.getResource(fileName);
            if (url == null) return null;
            f = new File(url.toURI());
        } catch (URISyntaxException e) {
            System.out.println("Cannot found file: '" + fileName + "' in resources! " + e);
            e.printStackTrace();
        }
        return f;
    }
}
