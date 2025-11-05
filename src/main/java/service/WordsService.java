package service;

import java.util.Set;

public interface WordsService {

    int countWords(String text, Set<String> stopWords);

}
