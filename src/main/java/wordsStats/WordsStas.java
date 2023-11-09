package wordsStats;

import textProcessing.WordFetcher;

import java.util.ArrayList;
import java.util.StringJoiner;

public class WordsStas {
    private ArrayList<WordOperation> operations;
    private final WordFetcher wordFetcher;

    public WordsStas(WordFetcher wordFetcher) {
        this.operations = new ArrayList<>();
        this.wordFetcher = wordFetcher;
    }

    public WordsStas addOperation(WordOperation operation) {
        operations.add(operation);
        return this;
    }

    public void generateStats() {
        String word;
        while((word = wordFetcher.getNextWord()) != null) {
            for(WordOperation operation : operations) {
                operation.ingestWord(word);
            }
        }
    }

    public String collectStatsSummary() {
        StringJoiner sj = new StringJoiner(", ");
        for(WordOperation operation : operations) {
            sj.add(operation.getStatSummary());
        }
        return  sj.toString();
    }
}
