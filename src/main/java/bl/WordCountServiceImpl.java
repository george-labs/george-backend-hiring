package bl;

import java.util.Arrays;

public class WordCountServiceImpl implements WordCountService {

    @Override
    public long countWords(String input) {
        if (input == null) {
            return 0;
        }

        String[] wordCandidates = input.split("\\s+");
        return Arrays.stream(wordCandidates)
                .filter(candidate -> candidate.matches("[a-zA-Z]+"))
                .count();
    }
}
