package application;

import application.infrastructure.config.StopWordsConfig;
import application.infrastructure.input.Input;
import application.infrastructure.output.Output;
import application.text.Text;

public final class ApplicationFacade {
    private final Input input;
    private final Output output;
    private final StopWordsConfig stopWordsConfig;

    public ApplicationFacade(final Input input, final Output output, final StopWordsConfig stopWordsConfig) {
        this.input = input;
        this.output = output;
        this.stopWordsConfig = stopWordsConfig;
    }

    public void countWords() {
        final String userText = input.getInput();
        final Text text = new Text(userText);
        final Long result = text.calculateWordsInSentence(stopWordsConfig.getStopWords());
        output.provideOutput(result);
    }
}
