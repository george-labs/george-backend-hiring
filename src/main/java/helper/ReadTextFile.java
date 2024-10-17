package helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadTextFile {

    public List<String> readResourceTextFile(){
        String line;
        List<String> outputList = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("stopwords.txt");

        if (inputStream == null){
            throw new IllegalArgumentException("Resource file is missing");
        }

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
