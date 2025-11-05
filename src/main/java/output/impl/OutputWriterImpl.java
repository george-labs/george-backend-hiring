package output.impl;

import output.OutputWriter;

public class OutputWriterImpl implements OutputWriter {

    @Override
    public void writeLine(String textLine) {
        System.out.println(textLine);
    }

}
