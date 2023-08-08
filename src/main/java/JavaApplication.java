import UserInteractions.IOOperations;
import operations.AlphabeticOperations;
import operations.FileOperations;
import operations.StringOperations;

public class JavaApplication
{
    public static void main(String[] args)
    {
        AlphabeticOperations operations;
        String sentence;

        if(args.length>0)
        {
            operations = new StringOperations(FileOperations.readFromFile(args[0],","));
            if(args.length==2)
                sentence = FileOperations.readFromFile(args[1]," ");
            else
                sentence = IOOperations.fetchSentence();
        }
        else
        {
            operations = new StringOperations();
            sentence = IOOperations.fetchSentence();

        }
        System.out.println("Number of words: " + operations.countWords(sentence,"[: .,-]")+", unique: " + operations.countUniqueWords(sentence,"[: .,-]"));
    }
}
