import repository.FileReader;
import repository.StopWordsProvideImpl;
import repository.StopWordsProvider;
import service.input.reader.FileReaderServiceImpl;
import service.input.reader.InputReaderService;
import service.input.reader.ConsoleReaderServiceImpl;
import service.counting.words.CountingWordsService;
import service.counting.words.CountingWordsServiceImpl;

public class JavaApplication {
    public static void main(String[] args) {
        StopWordsProvider stopWordsProvider = new StopWordsProvideImpl(new FileReader(), "stopwords.txt");

        InputReaderService inputReaderService;

        if (args != null && args.length > 0) {
            inputReaderService = new FileReaderServiceImpl(new FileReader(), args[0]);
        } else {
            inputReaderService = new ConsoleReaderServiceImpl();
        }


        CountingWordsService countingWordsServiceImpl = new CountingWordsServiceImpl(stopWordsProvider, inputReaderService);

        System.out.println("Number of words: " + countingWordsServiceImpl.countNumberOfWords());
    }
}
