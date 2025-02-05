package com.erste.wordcounter;

import java.util.List;

public record WordsCountInfo(int wordsCount, int uniqueWordsCount, double averageWordLength, List<String> index) {
}
