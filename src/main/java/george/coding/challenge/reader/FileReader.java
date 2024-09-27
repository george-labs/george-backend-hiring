package george.coding.challenge.reader;

import george.coding.challenge.job.provider.DataProvider;

import java.io.IOException;

public class FileReader implements TextReader {

    final String filename;

    public FileReader(String filename) {
        this.filename = filename;
    }

    @Override
    public String read() throws IOException {
        return read(filename);
    }

    public String read(String path) throws IOException {

        DataProvider dataProvider = new DataProvider(path);
        return String.join(" ", dataProvider.words());
    }

    @Override
    public void close() {
        // no resource to close
    }
}
