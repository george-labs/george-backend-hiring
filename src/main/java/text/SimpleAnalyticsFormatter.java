package text;

import java.util.Locale;

public class SimpleAnalyticsFormatter implements AnalyticsFormatter{

    @Override
    public String getFormattedData(TextAnalytics textAnalytics) {
        if (textAnalytics == null) {
            return "";
        }
        String formattedAverageLength = String.format(Locale.US,"%.2f", textAnalytics.getAverageWordLength());
        return "Number of words:" + textAnalytics.getWordCount()
                + ", unique: " + textAnalytics.getUniqueWordCount()
                + ", average word length: " + formattedAverageLength + " characters";
    }
}
