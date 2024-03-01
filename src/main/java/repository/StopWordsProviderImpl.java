package repository;

import java.util.List;

public class StopWordsProviderImpl implements StopWordsProvider {

    private final FileReader fileReader;
    private final String pathToFile;

    public StopWordsProviderImpl(FileReader fileReader, String pathToFile){
        this.fileReader = fileReader;
        this.pathToFile = pathToFile;
    }
    @Override
    public List<String> provideStopWords() {
        return this.fileReader.loadFile(pathToFile);
    }
}