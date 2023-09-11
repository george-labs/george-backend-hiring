package integration;

import domain.CountResult;

public class SystemWriteService implements IWriteService {
    private static final String ANSWER_TEMPLATE = "Number of words: %s, unique: %s";

    @Override
    public void writeWordCount(CountResult result) {
        System.out.printf(ANSWER_TEMPLATE, result.getCount(), result.getUniqueCount());
    }
}
