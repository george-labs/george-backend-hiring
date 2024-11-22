import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamReporter{

    public static final String WORD_COUNT_MESSAGE = "Word count ";
    private final OutputStream outputStream;

    public OutputStreamReporter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    OutputStream report(int wordCount) throws IOException {
        outputStream.write((WORD_COUNT_MESSAGE + wordCount).getBytes());
    }
}
