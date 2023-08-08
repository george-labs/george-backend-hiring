package operations;

import java.util.List;

public interface AlphabeticOperations
{
    List<String> countWords(String sentence);
    long uniqueWords(List<String> words);
}
