package sk.erste.wordcountkata;

public class WordCounterOutputFormatter {

    public String formatOutput(WordCounter.WordCountStat wordCountStat) {
        return String.format("Number of words: %d, unique: %d; average word length: %.2f characters" ,
                wordCountStat.wordCount(), wordCountStat.uniqueWordCount(), wordCountStat.avgLength());
    }
}
