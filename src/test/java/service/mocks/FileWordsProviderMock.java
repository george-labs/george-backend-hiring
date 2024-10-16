package service.mocks;

import input.WordsProvider;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class FileWordsProviderMock implements WordsProvider {

    private final List<String> words;

    public FileWordsProviderMock(List<String> words) {
        this.words = words;
    }

    @Override
    public Collection<String> getWords(String fileName) throws IOException {
        return words;
    }

}
