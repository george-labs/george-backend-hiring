package output;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void writeOutput(long count) {
        System.out.println("Number of words: " + count);
    }

}
