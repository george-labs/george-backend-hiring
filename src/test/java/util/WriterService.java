package util;

import integration.IWriteService;

public class WriterService implements IWriteService {
    int out;

    @Override
    public void writeWordCount(int count) {
        out = count;
    }

    public int getOut() {
        return out;
    }
}