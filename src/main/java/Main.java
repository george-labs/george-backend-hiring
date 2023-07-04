import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Handler handler = new Handler(new InputFileText(), new FileReaderText(), new StopWords());
        handler.handlingCountingByInput(args);

        StopWords stopWords = new StopWords();

        InputFileText inputFileText = new InputFileText();

        FileReaderText fileReaderText = new FileReaderText();

        stopWords.setStopWords(fileReaderText.readingTxtFileConvertingToListOfString("stopwords.txt"));
        if (args.length != 0) {
            inputFileText.readingFromWorkDirectory("filename.txt");

        } else {

            Sentence sentence = new Sentence(stopWords);

            System.out.println("Enter text: ");
            Scanner in = new Scanner(System.in);

            String inputSentence = in.nextLine();

            System.out.println("Number of words: " + sentence.countingWordsOnlyLetter(inputSentence));
        }
    }

}
