package operations;

import java.util.List;

public interface AlphabeticOperations
{
    List<String> countWords(String sentence, String separator);
    int countWords(String sentence);
    int countUniqueWords(String sentence, String separator);
}
