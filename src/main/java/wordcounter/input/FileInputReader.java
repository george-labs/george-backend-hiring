package wordcounter.input;

import wordcounter.FileReader;

import java.util.List;

public class FileInputReader implements InputReader {

    private final String fileName;
    private final FileReader fileReader;

    public FileInputReader(String fileName, FileReader fileReader) {
        this.fileName = fileName;
        this.fileReader = fileReader;
    }

    @Override
    public String readInput() {
        List<String> lines = fileReader.readFile(fileName);
        return String.join("\n", lines);
    }

}
