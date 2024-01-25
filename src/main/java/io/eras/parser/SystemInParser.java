package io.eras.parser;

import io.eras.supplier.InputSupplier;
import io.eras.util.WordCounter;

public class SystemInParser implements InputParser {

    private WordCounter wordCounter;

    private InputSupplier inputSupplier;

    public SystemInParser(WordCounter wordCounter, InputSupplier inputSupplier) {
        this.wordCounter = wordCounter;
        this.inputSupplier = inputSupplier;
    }

    @Override
    public long parse() {
        return wordCounter.countWords(inputSupplier.read());
    }
}
