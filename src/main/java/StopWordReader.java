import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class StopWordReader  {

    public Set<String> readStopWordsFromFile(String filePathString) throws IOException {

        HashSet<String> stopWords = new HashSet<>();
        File file = new File(filePathString);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String curLine;
        while ((curLine = bufferedReader.readLine()) != null){
            stopWords.add(curLine.trim());
        }

        return stopWords;
    }

}
