import java.io.IOException;
import java.util.Scanner;
import java.util.Set;


public class WordCount {

    private  boolean fileInput ;
    private String fileName;
    private static String stopWordFileName;

    public WordCount(String stopWordFileName) {
        this.stopWordFileName  = stopWordFileName;
    }

    public  int wordCount(String text) throws IOException {
        if (text == null || text.isEmpty())
            return 0;

        String[] splited = text.split("\\s+");

        Set<String> stopWords = getSetStopWords(stopWordFileName);

        int counter = 0;

        for (String word : splited) {

            if (word.matches("^[a-zA-Z]*$"))
                if (!stopWords.contains(word))
                    counter++;
        }

        return counter;

    }
    private  Set<String> getSetStopWords(String fileName) throws IOException {

        FileReader fileReader = new FileReader(fileName);
        return Set.of(fileReader.readFile().split("\\n"));
    }


}
