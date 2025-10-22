import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaApplication {
    public static void main(String[] args) throws FileNotFoundException {

        InputStream inputStream = JavaApplication.class.getClassLoader().getResourceAsStream("stopwords.txt");
        if (inputStream == null) {
            throw new FileNotFoundException("stopwords.txt not found in resources");
        }

        Scanner in = new Scanner(new InputStreamReader(inputStream));
        List<String> stopwords = new ArrayList<>();
        while (in.hasNextLine()) {
            stopwords.add(in.nextLine());
        }
        in.close();

        final WordCounter wordCounter = new WordCounter(stopwords);

        final String queryString = "Enter text: ";
        System.out.print(queryString);
        String line = readLine();

        long count = wordCounter.getWordCount(line);
        String outputMessageFormat = "Number of words: %d";
        System.out.printf(outputMessageFormat,  count);

    }

    private static String readLine() {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        input.close();
        return line;
    }
}
