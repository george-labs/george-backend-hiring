import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JavaApplication {

    static final String STOP_WORD_FILE_PATH = "src/main/resources/stopwords.txt";
    static final String ACCEPTED_CHARS = "^[a-zA-Z]*";

    public static List<String> getStopWordsFromFile(String fileName){
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            System.err.println("Exception while processing/opening the file. Message: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static int countWords(String input, String regex){
        List<String> stopWords = getStopWordsFromFile(STOP_WORD_FILE_PATH);
        int wordCount = 0;

        String[] inputWords = input.split(" ");

        for (String word: inputWords) {
            if(!word.isEmpty() && Pattern.matches(regex,word) && !stopWords.contains(word)){
                wordCount++;
            }
        }
        return  wordCount;
    }

    public static void main(String[] args){

        TextProcessor textProcessor = new TextProcessor();
        textProcessor.processText(args);
    }
}