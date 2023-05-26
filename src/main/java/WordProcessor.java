import java.util.List;
import java.util.regex.Pattern;

public class WordProcessor {


    public FileProcessor fileProcessor;

    public WordProcessor(FileProcessor fileProcessor){
        this.fileProcessor = fileProcessor;
    }

    public int countWords(String input, String regex, String stopWordFileName){
        List<String> stopWords = fileProcessor.getListOfLinesFromFile(stopWordFileName) ;
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
