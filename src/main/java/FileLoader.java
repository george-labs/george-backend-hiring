import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public static List<String> loadLinesFromFile(String filename) throws IOException {
        var bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        var lines = new ArrayList<String>();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

        return lines;
    }

}
