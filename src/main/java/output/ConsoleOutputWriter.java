package output;

public class ConsoleOutputWriter implements OutputWriter {

    @Override
    public void write(String output) {
        System.out.println(output);
    }

}
