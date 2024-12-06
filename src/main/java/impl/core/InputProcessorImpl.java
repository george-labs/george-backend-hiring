package impl.core;

import api.core.InputProcessor;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class InputProcessorImpl implements InputProcessor {

    @Override
    public int processScannedInput(final List<String> input, final List<String> stopWords) {
        final String joinedInputLines = String.join("\n", input);
        final List<String> words = Arrays.asList(joinedInputLines.split("\\s"));

        List<String> filteredInputWords = filterInputWords(words, stopWords);
        return filteredInputWords.size();
    }

    @NotNull
    public static List<String> filterInputWords(final List<String> inputWords, final List<String> forbiddenWords) {
        return inputWords.stream()
                .filter(word ->  !forbiddenWords.contains(word.toLowerCase()))
                .toList();
    }

}