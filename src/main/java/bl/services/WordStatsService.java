package bl.services;

import bl.model.WordStats;

public interface WordStatsService {

    WordStats countWords(String input, boolean createIndex);
}
