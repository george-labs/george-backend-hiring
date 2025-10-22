public class ConsoleOutputWriter implements OutputWriter {

    @Override
    public void writeOutput(String output) {
        System.out.printf(output);
    }
}
