package bootstrap;

import counter.WordCounter;
import handler.Handler;

import java.io.IOException;

public class Bootstrap {
    private final WordCounter wordCounter;
    private final Handler handler;

    public Bootstrap(WordCounter wordCounter, Handler handler) {
        this.wordCounter = wordCounter;
        this.handler = handler;
    }

    public int count() throws IOException {
        return wordCounter.count(handler.handle());
    }

    private String getFilePath(String[] args) {
        if (args.length == 0) {
            return null;
        }

        return args[0];
    }
}
