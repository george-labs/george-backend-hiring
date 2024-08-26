package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class ResourceUtils {

    public static void populateStopWords(List<String> stopWords) {
        var resource = ResourceUtils.class.getClassLoader().getResource("stopwords.txt");
        var filePath = resource.getPath();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));) {
            for (String word : stopWords) {
                writer.write(word);
                writer.newLine();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
