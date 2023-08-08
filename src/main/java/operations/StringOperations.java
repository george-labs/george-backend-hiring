package operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringOperations implements AlphabeticOperations
{

    private List<String> blacklist;
    private final String separator = "[: .,]";

    public StringOperations()
    {
        blacklist = new ArrayList<>();
    }

    public StringOperations(String blacklistedWords)
    {
        blacklist = Arrays.asList(blacklistedWords.split(separator));
    }

    public List<String> countWords(String sentence)
    {
        String[] sentenceArray = sentence.split(separator);
        List<String> sentenceList = new ArrayList<>();
        for(String word: sentenceArray)
        {
            if(word.compareTo("")!=0 && !blacklist.contains(word))
            {
                sentenceList.add(word);
            }
        }
        return sentenceList;
    }

    public long uniqueWords(List<String> words)
    {
        return words.stream().distinct().count();
    }

    public float averageCountOfWords(List<String> words)
    {
        float sum = 0;
        int count = 0;
        for(String word: words)
        {
            sum = sum + word.length();
            count++;
        }
        return sum/count;
    }

}
