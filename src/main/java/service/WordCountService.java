package service;

import java.util.List;

public interface WordCountService {
    int checkTheCountOfWord(String text);

    List<String> getWords(String text);
}
