import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderText {
    public List<String> readingTxtFileConvertingToListOfString(String fileName) throws IOException {

        // list that holds strings of a file
        List<String> listWords = new ArrayList<>();

        BufferedReader reader = gettingFileFromResources(fileName);
        String line;
        while ((line = reader.readLine()) != null) {
            listWords.add(line);
        }
        // storing the data in arraylist to array
        return listWords;
    }

    @NotNull
    private static BufferedReader gettingFileFromResources(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        return reader;
    }
}
