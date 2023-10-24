package service.impl;

import model.Input;
import model.Output;
import model.Words;
import service.Fetcher;
import service.Parser;
import service.Presenter;
import service.WordCountProcessor;

public class WordCountProcessorImpl implements WordCountProcessor {

    private final Fetcher fetcher;
    private final Parser parser;
    private final Presenter presenter;

    public WordCountProcessorImpl(Fetcher fetcher, Parser parser, Presenter presenter) {
        this.fetcher = fetcher;
        this.parser = parser;
        this.presenter = presenter;
    }

    @Override
    public String processWordCounting(String input) {
        Input fetchInput = fetcher.fetch(input);
        Words words = parser.parse(fetchInput);
        Output presentedOutput = presenter.present(words);
        return presentedOutput.getOutput();
    }
}
