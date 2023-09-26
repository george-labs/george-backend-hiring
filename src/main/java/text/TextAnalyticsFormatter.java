package text;

import java.util.Locale;

public class TextAnalyticsFormatter {
    private final boolean indexed;
    public TextAnalyticsFormatter(boolean indexed) {
        this.indexed = indexed;
    }

    public String getFormattedData(TextAnalytics textAnalytics) {
        if (textAnalytics == null) {
            return "";
        }
        String formattedAverageLength = String.format(Locale.US,"%.2f", textAnalytics.getAverageWordLength());
        var stringBuilder =
                new StringBuilder().append("Number of words:").append(textAnalytics.getWordCount())
                        .append(", unique: ").append(textAnalytics.getUniqueWordCount())
                        .append(", average word length: ").append(formattedAverageLength).append(" characters");
        if (indexed) {
            stringBuilder.append("Index:\n")
                    .append(String.join("\n", textAnalytics.getWords()));
        }
        return stringBuilder.toString();
    }
}
