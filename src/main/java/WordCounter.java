import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WordCounter {

    public static final String STOPWORD_FILE_PATH = "src/main/resources/stopwords.txt";
    public static final String STOPWORD_TXT_WAS_NOT_FOUND = "STOPWORD.TXT WAS NOT FOUND!";
    public static final String READING_FILE_ERROR_MESSAGE = "READING FILE ERROR!";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String line = sc.nextLine();
        List<String> stopWords = getStopWordsFromFile();
        System.out.println("Number of words: " + count(line, stopWords));
    }

    public static List<String> getStopWordsFromFile(){
        List<String> stopWords = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(STOPWORD_FILE_PATH));
            String line = br.readLine();

            while (line != null) {
                stopWords.add(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(STOPWORD_TXT_WAS_NOT_FOUND);
        } catch (IOException e){
            System.out.println(READING_FILE_ERROR_MESSAGE);
            e.printStackTrace();
        }
        return stopWords;
    }

    public static int count(String line, List<String> stopWords) {
        return Arrays.stream(line
                .trim()                                     // cut spaces at the start and end of the string
                .replaceAll("\\s+"," ")     // replace more spaces by one
                .split(" "))                          // split by space into array
                .filter(word -> !stopWords.contains(word))  // exclude stopwords
                .toArray()                                  // transformation to array
                .length;                                    // return length of array
    }
}
