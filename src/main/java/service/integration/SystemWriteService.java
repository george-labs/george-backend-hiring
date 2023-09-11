package service.integration;

public class SystemWriteService implements IWriteService {
    private static final String PREFIX_ANSWER = "Number of words:%s";

    @Override
    public void writeWordCount(int count) {
        System.out.printf(PREFIX_ANSWER, count);
    }
}
