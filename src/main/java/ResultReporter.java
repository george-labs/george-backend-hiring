public class ResultReporter {

    private final Reporter reporter;

    public ResultReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public String report(int wordCount){
        return reporter.report(wordCount);
    }

}
