package service.mocks;

import output.OutputWriter;

public class OutputWriterMock implements OutputWriter {

    @Override
    public void write(String output) {
        System.out.println(output);
    }

}
