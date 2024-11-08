import java.util.List;

public interface StopWordsProvider {

    /**
     * Provides list of stop words.
     *
     * @return List of strings that are considered stop words.
     * */
    List<String> provideStopWords();
}
