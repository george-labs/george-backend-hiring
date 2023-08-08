import UserInteractions.IOOperations;
import operations.StringOperations;

public class JavaApplication
{
    public static void main(String[] args)
    {
        String sentence = IOOperations.fetchSentence();
        if(sentence!=null)
        {
            System.out.println("Number of words: " + StringOperations.countWords(sentence));
        }
        else
        {
            System.out.println("Invalid Input");
        }
    }
}
