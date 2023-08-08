package operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringOperations implements AlphabeticOperations
{
    private List<String> blacklist;

    public StringOperations()
    {
        blacklist = new ArrayList<>();
    }

    public StringOperations(String blacklistedWords)
    {
        blacklist = Arrays.asList(blacklistedWords.split(","));
    }

    public int countWords(String sentence, String separator)
    {
        String[] sentenceArray = sentence.split(separator);
        if(sentenceArray.length==1)
        {
            if(sentenceArray[0].compareTo("")==0)
            {
                return 0;
            }

        }
        int count = 0;
        for (String word: sentenceArray)
        {
            if(blacklist.contains(word))
            {
                continue;
            }
            count++;

        }
        return count;
    }

    public int countWords(String sentence)
    {
        return countWords(sentence, " ");
    }
}
