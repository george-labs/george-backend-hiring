package application;

import application.infrastructure.input.Input;
import application.infrastructure.output.Output;
import application.text.Text;

public final class ApplicationFacade {
    private final Input input;
    private final Output output;

    public ApplicationFacade(final Input input, final Output output) {
        this.input = input;
        this.output = output;
    }

    public void countWords() {
        final String userText = input.getInput();
        final Text text = new Text(userText);
        final Long result = text.calculateWordsInSentence();
        output.provideOutput(result);
    }
}
