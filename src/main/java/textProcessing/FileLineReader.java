package textProcessing;

import java.util.Scanner;

public class FileLineReader implements LineReader{

    private final Scanner source;

    public FileLineReader(Scanner source) {
        this.source = source;
    }

    @Override
    public String getLine() {
        if(source.hasNext()) {
            return source.nextLine();
        }
        return null;
    }
}
