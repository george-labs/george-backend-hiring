package providers;


import java.io.*;

public class FileInputDataProvider implements IDataProvider {

    private final String fileName;

    public FileInputDataProvider(String fileName) {
        this.fileName = fileName;
    }

    private String getDataFromFile(String fileName) throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        String str = new String(inputStream.readAllBytes()).replaceAll("(\\r|\\n)", " ");
        return str;
    }

    @Override
    public String getData() throws IOException {
        return getDataFromFile(fileName);
    }
}
