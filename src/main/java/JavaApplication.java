import UserInteractions.IOOperations;
import operations.AlphabeticOperations;
import operations.FileOperations;
import operations.StringOperations;

public class JavaApplication
{
    public static void main(String[] args)
    {
        AlphabeticOperations operations = new StringOperations(FileOperations.readFromFile(args[0]));
        String sentence = IOOperations.fetchSentence();
        if(sentence!=null)
        {
            System.out.println("Number of words: " + operations.countWords(sentence));
        }
        else {
            System.out.println("Invalid Input");
        }
    }
}
