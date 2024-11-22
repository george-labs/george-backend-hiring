public class SOutReporter implements Reporter{

    @Override
    public void report(int wordCount) {
        System.out.println("Word count " + wordCount);
    }
}
