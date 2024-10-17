package helper;

import exception.FileIsMissingException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadTextFile {

    public List<String> readResourceTextFile() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("stopwords.txt");
        if (inputStream == null) {
            throw new IllegalArgumentException("Resource file is missing");
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        return readFileByInputStream(bufferedReader);
    }


    public List<String> readFile(String pathToFile) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile));
            return readFileByInputStream(bufferedReader);
        } catch (FileNotFoundException e) {
            throw new FileIsMissingException(e.getMessage());
        }
    }

    private List<String> readFileByInputStream(BufferedReader bufferedReader) {
        String line;
        List<String> outputList = new ArrayList<>();

        try {
            while ((line = bufferedReader.readLine()) != null) {
                outputList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return outputList;
    }
}

