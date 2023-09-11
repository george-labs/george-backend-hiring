package util;

import domain.CountResult;
import integration.IWriteService;

public class WriterService implements IWriteService {
    CountResult result;

    @Override
    public void writeWordCount(CountResult result) {
        this.result = result;
    }

    public int getCount() {
        return result.getCount();
    }

    public int getUniqueCount() {
        return result.getUniqueCount();
    }
}