import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WordCounter {

    public static final String STOPWORD_FILE_PATH = "stopwords.txt";
    public static final String STOPWORD_TXT_WAS_NOT_FOUND = "STOPWORD.TXT WAS NOT FOUND!";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String line = sc.nextLine();
        System.out.println("Number of words: " + count(line));
    }

    public static List<String> getStopWords(){
        List<String> stopwords = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(STOPWORD_FILE_PATH));
            String line = br.readLine();

            while (line != null) {

                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(STOPWORD_TXT_WAS_NOT_FOUND);
        } catch (IOException e){
            e.printStackTrace();
        }
        return stopwords;
    }

    public static int count(String line) {
        return line
                .trim()                                     // cut spaces at the start and end of the string
                .replaceAll("\\s+"," ")     // replace more spaces by one
                .split(" ")                           // split by space into array
                .length;                                    // return length of array
    }
}
