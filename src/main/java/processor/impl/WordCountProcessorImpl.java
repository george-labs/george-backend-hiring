package processor.impl;

import model.Input;
import model.Output;
import model.Words;
import service.Fetcher;
import service.Filter;
import service.Parser;
import service.Presenter;
import processor.WordCountProcessor;

public class WordCountProcessorImpl implements WordCountProcessor {

    private final Fetcher fetcher;
    private final Parser parser;
    private final Presenter presenter;
    private final Filter stopWordsFilter;

    public WordCountProcessorImpl(Fetcher fetcher, Parser parser, Presenter presenter, Filter stopWordsFilter) {
        this.fetcher = fetcher;
        this.parser = parser;
        this.presenter = presenter;
        this.stopWordsFilter = stopWordsFilter;
    }

    @Override
    public String processWordCounting(String input) {
        Input fetchInput = fetcher.fetch();
        Words words = parser.parse(fetchInput);
        Words filteredWords = stopWordsFilter.filter(words);
        Output presentedOutput = presenter.present(filteredWords);
        return presentedOutput.getOutput();
    }

}
