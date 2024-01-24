package providers;


import utils.Constants;

import java.io.*;

public class FileInputDataProvider implements IDataProvider {

    private final String fileName;

    public FileInputDataProvider(String fileName) {
        this.fileName = fileName;
    }

    private String getDataFromFile(String fileName) throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder sb = new StringBuilder();

        while(reader.ready()) {
            String line = reader.readLine();
            sb.append(line + Constants.REGEX);
        }
        return sb.toString();
    }

    @Override
    public String getData() throws IOException {
        return getDataFromFile(fileName);
    }
}
