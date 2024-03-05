package bl.services;

import bl.model.WordStats;

public interface WordCountService {

    WordStats countWords(String input);
}
