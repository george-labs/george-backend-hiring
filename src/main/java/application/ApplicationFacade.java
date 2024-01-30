package application;

import application.infrastructure.config.StopWordsConfig;
import application.infrastructure.exceptions.NoFileFoundException;
import application.infrastructure.input.InputFactory;
import application.infrastructure.output.Output;
import application.text.Text;

import java.util.List;

import static application.infrastructure.InfrastructureConstants.EMPTY_STRING;
import static application.infrastructure.InfrastructureConstants.NO_SUCH_FILE;

public final class ApplicationFacade {
    private final InputFactory inputFactory;
    private final Output output;
    private final StopWordsConfig stopWordsConfig;

    public ApplicationFacade(final InputFactory inputFactory, final Output output, final StopWordsConfig stopWordsConfig) {
        this.inputFactory = inputFactory;
        this.output = output;
        this.stopWordsConfig = stopWordsConfig;
    }

    public void countWords(final String[] args) {
        final String fileName = args.length > 0 ? args[0] : EMPTY_STRING;
        try {
            final String userText = inputFactory.getInput(fileName);
            final Text text = new Text(userText);
            final List<String> stopWords = stopWordsConfig.getStopWords();
            final Long totalCount = text.calculateWordsInText(stopWords);
            final Long uniqueCount = text.calculateUniqueWordsInText(stopWords);
            output.provideOutput(totalCount, uniqueCount);
        } catch (NoFileFoundException e) {
            System.out.println(NO_SUCH_FILE);
        }
    }
}
