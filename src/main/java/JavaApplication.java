import repository.FileReader;
import repository.StopWordsProvider;
import service.console.reader.ConsoleReaderService;
import service.console.reader.ConsoleReaderServiceImpl;
import service.counting.words.CountingWordsService;
import service.counting.words.CountingWordsServiceImpl;

public class JavaApplication {
    public static void main(String[] args){
        StopWordsProvider stopWordsProvider = new FileReader();
        ConsoleReaderService consoleReaderService = new ConsoleReaderServiceImpl();
        CountingWordsService countingWordsServiceImpl = new CountingWordsServiceImpl(stopWordsProvider, consoleReaderService);

        System.out.println("Number of words: " + countingWordsServiceImpl.countNumberOfWords());
    }
}
