package stopwords;

import exception.NotFoundException;
import filereader.FileReaderService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordsReaderImpl implements StopWordsReader {

    private final StopWordsReaderConfiguration stopWordsReaderConfiguration;
    private final FileReaderService fileReaderService;

    public StopWordsReaderImpl(final StopWordsReaderConfiguration stopWordsReaderConfiguration,
                               final FileReaderService fileReaderService) {
        this.stopWordsReaderConfiguration = stopWordsReaderConfiguration;
        this.fileReaderService = fileReaderService;
    }

    @Override
    public Set<String> getStopWordsList() {
        final String stopWordsFileName = stopWordsReaderConfiguration.getStopWordsFileName();
        try {
            final List<String> stopWords = fileReaderService.readFileAsList(stopWordsFileName);

            return stopWords
                    .stream()
                    .collect(Collectors.toUnmodifiableSet());
        } catch (NotFoundException e) {
            throw new StopWordsException(String.format("File '%s' not found", stopWordsFileName), e);
        }
    }

}
