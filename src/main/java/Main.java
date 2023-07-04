import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        StopWords stopWords = new StopWords();
        FileReaderText fileReaderText = new FileReaderText();

        try {
            stopWords.setStopWords(fileReaderText.readingTxtFileConvertingToListOfString("stopwords.txt"));
        } catch (IOException e) {
            System.out.println("Application is not working");
        }

        System.out.println("Enter text: ");
        Scanner in = new Scanner(System.in);

        Sentence sentence = new Sentence(stopWords);
        String inputSentence = in.nextLine();

        System.out.println("Number of words: " + sentence.countingWordsOnlyLetter(inputSentence));
    }
}
