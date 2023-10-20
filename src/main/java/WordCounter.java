import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {

    private static Pattern validWords = Pattern.compile("[a-zA-Z]+");


    public long countWords(String words){
        return Arrays.stream(words.split("\\s+"))
                .filter(this::isWordValid)
                .filter(this::containStopWords)
                .count();
    }

    private boolean isWordValid(String word){
        return validWords.matcher(word).matches();
    }

    private boolean containStopWords(String word){
        List<String> stopwords = readStopWordsFromFile();
        return !stopwords.contains(word);
    }

   private List<String> readStopWordsFromFile(){
        List<String> stopwords = new ArrayList<>();
        String fileName = "stopwords.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            stopwords = br.lines().collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }
        return stopwords;
   }

}


