package factory;

import processor.WordCountProcessor;
import processor.impl.WordCountProcessorImpl;

import service.Fetcher;
import service.Filter;
import service.Parser;
import service.Presenter;
import service.impl.FetcherByCommandLineImpl;
import service.impl.FetcherByFilenameImpl;
import service.impl.ParserImpl;
import service.impl.PresenterImpl;

public class WordsCountProcessorFactory {

    private final static String STOP_WORDS_FILENAME = "stopwords.txt";

    public static WordCountProcessor createFrom(String[] args) {
        //TODO should be switched to the FetcherFactory
        if (isFilenameWithin(args)) {
            return createWordCountFileProcessor(args);
        }

        return createWordCountCommandLineProcessor();
    }

    private static boolean isFilenameWithin(String[] args) {
        return args.length > 0;
    }

    private static WordCountProcessor createWordCountCommandLineProcessor() {
        Fetcher fetcher = new FetcherByCommandLineImpl();
        Parser parser = new ParserImpl();
        Filter stopWordsFilter = FilterFactory.createWith(STOP_WORDS_FILENAME);
        Presenter presenter = new PresenterImpl();
        return new WordCountProcessorImpl(fetcher, parser, presenter, stopWordsFilter);
    }

    private static WordCountProcessor createWordCountFileProcessor(String[] args) {
        Fetcher fetcher = new FetcherByFilenameImpl(args[0]);
        Parser parser = new ParserImpl();
        Filter stopWordsFilter = FilterFactory.createWith(STOP_WORDS_FILENAME);
        Presenter presenter = new PresenterImpl();
        return new WordCountProcessorImpl(fetcher, parser, presenter, stopWordsFilter);
    }
}
