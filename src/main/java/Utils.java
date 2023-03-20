import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    static List<String> loadFileByLines(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(getFileFromResources(fileName)))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error while reading file: '" + fileName + "'" + e);
            e.printStackTrace();
        }
        return lines;
    }

    static File getFileFromResources(String filename) {
        File f = null;
        try {
            f = new File(WordCounter.class.getResource(filename).toURI());
        } catch (URISyntaxException e) {
            System.out.println("Cannot found file: '" + filename + "' in resources! " + e);
            e.printStackTrace();
        }
        return f;
    }

}
