import app.SpaceWordCounter;
import app.WordCounter;
import in.ConsoleReader;
import out.ConsoleWriter;

public class JavaApplication {

    public static void main(String[] args) {

        // CONF
        WordCounter wordCounter = new SpaceWordCounter();
        ConsoleReader consoleReader = new ConsoleReader();
        ConsoleWriter consoleWriter = new ConsoleWriter();

        // IN


        // APP
//        wordCounter
        wordCounter.countWords()

        // OUT
        consoleWriter.writeWordCountOutput();



    }

}
