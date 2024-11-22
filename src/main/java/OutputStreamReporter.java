import java.io.OutputStream;

public class OutputStreamReporter implements Reporter{

    private final OutputStream outputStream;

    public OutputStreamReporter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void report(int wordCount) {
        System.out.println("Word count " + wordCount);

    }
}
