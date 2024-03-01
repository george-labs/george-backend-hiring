package service.input.reader;

import repository.FileReader;

import java.util.List;

public class FileReaderServiceImpl implements InputReaderService{

    private final FileReader fileReader;
    private final String pathToFile;

    public FileReaderServiceImpl(FileReader fileReader, String pathToFile){
        this.fileReader = fileReader;
        this.pathToFile = pathToFile;
    }
    @Override
    public String getInputText() {
        List<String> text = fileReader.loadFile(pathToFile);
        return String.join(" ", text);
    }
}
