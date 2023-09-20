package app.mocks;

import output.OutputWriter;

public class OutputWriterMock implements OutputWriter {

    private long count;

    @Override
    public void writeOutput(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

}
