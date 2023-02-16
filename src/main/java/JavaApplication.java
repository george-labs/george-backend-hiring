import io.IFileHandler;
import io.LocalFileHandler;
import service.WordCountService;

public class JavaApplication {

    public static void main(String[] args) {
        IFileHandler fileHandler = new LocalFileHandler();
        WordCountService wordCountService = new WordCountService(fileHandler);
        if (args.length == 0) {
            wordCountService.countWords(null);
        } else {
            wordCountService.countWords(args[0]);
        }
    }

}
