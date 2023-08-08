import UserInteractions.IOOperations;

public class JavaApplication
{
    public static void main(String[] args)
    {
        String sentence = IOOperations.fetchSentence();
        if(sentence!=null)
        {
            System.out.println("Total ");
        }
    }
}
