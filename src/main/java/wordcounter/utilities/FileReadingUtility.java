package wordcounter.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileReadingUtility {

    public static Set<String> readStopwords(){

        Set<String> stopWords = new HashSet<>();
        try{
            Scanner file = new Scanner(new FileReader("src/main/resources/stopwords.txt"));
            while(file.hasNext()){
                stopWords.add(file.nextLine());
            }
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        return stopWords;
    }

}
