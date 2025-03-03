import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    public static final String STOPWORD_TXT_WAS_NOT_FOUND = "STOPWORD.TXT WAS NOT FOUND!";
    public static final String READING_FILE_ERROR_MESSAGE = "READING FILE ERROR!";

    public List<String> getStopWords(String path) {
        return Arrays.stream(getContent(path).split(" ")).toList();
    }

    public String getContent(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(path))) {

            String line = br.readLine();

            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(" ");
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(STOPWORD_TXT_WAS_NOT_FOUND);
        } catch (IOException e){
            System.out.println(READING_FILE_ERROR_MESSAGE);
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
