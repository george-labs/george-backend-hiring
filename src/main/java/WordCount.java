import java.io.IOException;
import java.util.Scanner;
import java.util.Set;


public class WordCount {
    public static void main(String[] args) throws IOException {

        Scanner  scanner = new Scanner(System.in);
        System.out.println("Please enter  text:");
        String  text  = scanner.nextLine();
        scanner.close();
        int counter  = wordCount(text);
        System.out.println("The  word count  is:"+counter );


    }
    public static int wordCount(String text ) throws IOException {
        if  (text == null || text.isEmpty())
                return  0;

        String[] splited = text.split("\\s+");
        FileReader fileReader = new FileReader("stopwords.txt");
        Set<String> stopWords = Set.of(fileReader.readStopFile().split("\\n"));

        int counter =0;

        for( String  word: splited) {

            if (word.matches("^[a-zA-Z]*$"))
                if(!stopWords.contains(word))
                    counter++;
        }

        return counter;

    }
}
