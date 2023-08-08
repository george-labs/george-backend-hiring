import UserInteractions.IOOperations;
import operations.AlphabeticOperations;
import operations.FileOperations;
import operations.StringOperations;

import java.util.List;

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
        List<String> sentenceList = operations.countWords(sentence);
        System.out.println("Number of words: " + sentenceList.size() +
                ", unique: " + operations.uniqueWords(sentenceList) +
                "; average word length: " + operations.averageCountOfWords(sentenceList) +" characters");
    }
}
