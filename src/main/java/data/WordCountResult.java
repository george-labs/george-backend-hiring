package data;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Set;

public record WordCountResult (long wordCount, Set<String> uniqueWords, float averageLength) {

    @NotNull
    @Override
    public String toString() {
        return String.format(Locale.US,"Number of words: %d, unique: %d; average word length: %.2f characters", wordCount, uniqueWords.size(), averageLength);
    }
}
