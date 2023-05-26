import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;

public class WordProcessor {



    public static List<String> getStopWordsFromFile(String fileName){
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            System.err.println("Exception while processing/opening the file. Message: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static int countWords(String input, String regex, String stopWordFileName){
        List<String> stopWords = getStopWordsFromFile(Constants.RESOURCE_PATH+stopWordFileName);
        int wordCount = 0;

        String[] inputWords = input.split(" ");

        for (String word: inputWords) {
            if(!word.isEmpty() && Pattern.matches(regex,word) && !stopWords.contains(word)){
                wordCount++;
            }
        }
        return  wordCount;
    }


}
