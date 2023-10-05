package bootstrap;

import counter.CounterResult;
import counter.WordCounter;
import handler.InputHandler;

import java.io.IOException;

public class Bootstrap {
    private final WordCounter wordCounter;
    private final InputHandler inputHandler;

    public Bootstrap(WordCounter wordCounter, InputHandler inputHandler) {
        this.wordCounter = wordCounter;
        this.inputHandler = inputHandler;
    }

    public CounterResult count() throws IOException {
        return wordCounter.process(inputHandler.handle());
    }
}
