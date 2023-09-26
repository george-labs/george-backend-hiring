package text;

import java.util.Locale;

public class TextAnalyticsFormatter {
    private final TextAnalytics textAnalytics;

    public TextAnalyticsFormatter(TextAnalytics textAnalytics) {
        this.textAnalytics = textAnalytics;
    }

    public String getFormattedData() {
        if (textAnalytics == null) {
            return "";
        }
        String formattedAverageLength = String.format(Locale.US,"%.2f", textAnalytics.getAverageWordLength());
        return "Number of words:" + textAnalytics.getWordCount()
                + ", unique: " + textAnalytics.getUniqueWordCount()
                + ", average word length: " + formattedAverageLength + " characters";
    }
}
