package application;

import application.infrastructure.config.StopWordsConfig;
import application.infrastructure.input.InputFactory;
import application.infrastructure.output.Output;
import application.text.Text;

import static application.infrastructure.InfrastructureConstants.EMPTY_STRING;

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
        final String userText = inputFactory.getInput(fileName);
        final Text text = new Text(userText);
        final Long result = text.calculateWordsInText(stopWordsConfig.getStopWords());
        output.provideOutput(result);
    }
}
