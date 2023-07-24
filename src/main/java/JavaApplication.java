import com.quiz.IWordCount;
import com.quiz.WordCount;
import com.quiz.reader.ArgReadingFactory;
import com.quiz.reader.FileReader;
import com.quiz.reader.Reader;

public class JavaApplication {
    public static void main(String[] args) {
        Reader reader = new ArgReadingFactory().create(args);
        IWordCount wordCount = new WordCount(new FileReader("stopwords.txt"));
        System.out.printf("Number of words: %s", wordCount.count(reader.read()));
    }
}
