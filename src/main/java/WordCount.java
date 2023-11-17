import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    private static String readStopFile() throws IOException {
        ClassLoader classLoader = WordCount.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("stopwords.txt");
        String data = readFromInputStream(inputStream);
        return data;
    }
    private static String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public static int wordCount(String text ) throws IOException {
        if  (text == null || text.isEmpty())
                return  0;

        String[] splited = text.split("\\s+");
        Set<String> stopWords = Set.of(readStopFile().split("\\n"));

        int counter =0;

        for( String  word: splited) {


            if (word.matches("^[a-zA-Z]*$"))
                if(!stopWords.contains(word))
                    counter++;
        }

        return counter;

    }
}
