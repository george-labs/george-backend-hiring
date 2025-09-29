import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FileReadingService {
    public Set<String> getStopWords(String fileForStopwords) {
        URL url = this.getClass().getResource(fileForStopwords);
        if(url == null){
            return Collections.emptySet();
        }

        Set<String> stopwords = new HashSet<>();
        try(BufferedReader br = new BufferedReader(new FileReader(url.getFile()))){
            String currentLine = br.readLine();
            while(currentLine != null){
                if(!currentLine.trim().isEmpty()){
                    stopwords.add(currentLine.trim());
                }
                currentLine = br.readLine();
            }
        }catch(IOException ioException){
            System.out.println("Could not find file: " + fileForStopwords);
        }
        return stopwords;
    }
}
