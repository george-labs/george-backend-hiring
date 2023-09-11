package service.stop_word;

import java.util.Set;

public interface IStopWordProvider {
    Set<String> getStopWords();
}
