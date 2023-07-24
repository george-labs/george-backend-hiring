import com.quiz.IWordCount;
import com.quiz.WordCount;
import com.quiz.reader.ConsoleReader;
import com.quiz.reader.Reader;

public class JavaApplication {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        IWordCount wordCount = new WordCount();
        System.out.printf("Number of words: %s", wordCount.count(reader.read()));
    }
}
