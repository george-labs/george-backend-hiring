import java.io.OutputStream;

public class ResultReporter {

    private final Reporter reporter;

    public ResultReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public void report(int wordCount){
        reporter.report(wordCount);
    }

}
