import java.io.*;

public class FileReader {

    private String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public String readFile() throws IOException {
        ClassLoader classLoader = WordCount.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        String data = "";
        if (inputStream != null)
           data = readFromInputStream(inputStream);
        return data;
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

}
