import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {


    public int countWords(String input){
        String[] words = input.split(" ");
        List<String> wordList = List.of(words);

        List<String> actualWords = new ArrayList<>();

        wordList.forEach(word -> {
            if (!word.isEmpty()){

                String regex = "^[a-zA-Z]+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(word);

                if (matcher.find()){
                    actualWords.add(word);
                }
            }
        });

        return actualWords.size();
    }


}
