package impl.writers;

import api.writers.OutputWriter;

public class OutputWriterImpl implements OutputWriter {

    @Override
    public void writeToTerminal(String output) {
        System.out.println(output);
    }
}