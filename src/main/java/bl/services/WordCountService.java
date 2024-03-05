package bl.services;

import bl.model.WordCount;

public interface WordCountService {

    WordCount countWords(String input);
}
