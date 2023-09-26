package input;

import file.FileHandler;

public class FileInputReader implements InputReader {
    private final FileHandler fileHandler;
    private final String fileName;

    public FileInputReader(FileHandler fileHandler, String fileName) {
        this.fileHandler = fileHandler;
        this.fileName = fileName;
    }

    @Override
    public String getInputText() {
        return fileHandler.readFileToString(fileName);
    }
}
