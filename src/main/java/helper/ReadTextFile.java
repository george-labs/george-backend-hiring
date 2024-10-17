package helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadTextFile {

    public List<String> readResourceTextFile() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("stopwords.txt");

        if (inputStream == null) {
            throw new IllegalArgumentException("Resource file is missing");
        }
        return  readFileByInputStream(inputStream);
    }


    public List<String> readFile(String pathToFile){

        Path path = Paths.get(pathToFile);
        try {
           return Files.readAllLines(path.getFileName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> readFileByInputStream(InputStream inputStream){
        String line;
        List<String> outputList = new ArrayList<>();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            try {
                while ((line = bufferedReader.readLine())!= null){
                    outputList.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return outputList;
        }
    }
}
