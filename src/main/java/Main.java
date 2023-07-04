import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        StopWords stopWords = new StopWords();

        FileReaderText fileReaderText = new FileReaderText();

        stopWords.setStopWords(fileReaderText.readingTxtFileConvertingToListOfString("stopwords.txt"));

        Sentence sentence = new Sentence(stopWords);

        System.out.println("Enter text: ");
        Scanner in = new Scanner(System.in);

        String inputSentence = in.nextLine();

        System.out.println("Number of words: " + sentence.countingWordsOnlyLetter(inputSentence));
    }
}
