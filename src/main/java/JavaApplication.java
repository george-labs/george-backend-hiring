import application.*;
import service.CountService;
import service.Reader;
import service.ReaderFactory;

public class JavaApplication {

    public static void main(String[] args) {
        ReaderFactory readerFactory = new ReaderFactory();
        Reader reader = readerFactory.createReader(args);
        App app = new App(reader, new CountService(), System.out);
        app.application();
    }
}
