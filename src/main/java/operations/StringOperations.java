package operations;

public class StringOperations
{
    public static int countWords(String sentence, String separator)
    {
        return sentence.split(" ").length;
    }

    public static int countWords(String sentence)
    {
        return countWords(sentence, " ");
    }
}
