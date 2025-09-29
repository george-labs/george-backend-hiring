import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class FileReadingService implements IFileReadingService{
    @Override
    public List<String> getFileContent(String file) {
        URL url = this.getClass().getResource(file);
        if(url == null){
            return Collections.emptyList();
        }

        List<String> content = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(url.getFile()))){
            String currentLine = br.readLine();
            while(currentLine != null){
                if(!currentLine.trim().isEmpty()){
                    content.add(currentLine.trim());
                }
                currentLine = br.readLine();
            }
        }catch(IOException ioException){
            System.out.println("Could not find file: " + file);
        }
        return content;
    }
}
