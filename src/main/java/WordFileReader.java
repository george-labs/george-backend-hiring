import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordFileReader {
    public static List<String> loadFileIntoList(String filename) throws IOException {
        List<String> fileItems = new ArrayList<>();
        InputStream inputStream = WordFileReader.class.getClassLoader().getResourceAsStream(filename);
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            while(line != null) {
                fileItems.add(line);
                line = reader.readLine();
            }
            reader.close();
            return fileItems;
        } else {
            throw new FileNotFoundException("File Does not exist");
        }
    }
}
