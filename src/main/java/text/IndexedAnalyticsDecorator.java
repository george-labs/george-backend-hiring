package text;

import java.util.Set;

public class IndexedAnalyticsDecorator implements AnalyticsFormatter{
    private final Set<String> dictionary;
    private final AnalyticsFormatter analyticsFormatter;

    public IndexedAnalyticsDecorator(AnalyticsFormatter analyticsFormatter, Set<String> dictionary) {
        this.analyticsFormatter = analyticsFormatter;
        this.dictionary = dictionary;
    }

    @Override
    public String getFormattedData(TextAnalytics textAnalytics) {
        var stringBuilder = new StringBuilder(analyticsFormatter.getFormattedData(textAnalytics));
        stringBuilder.append("\nIndex:\n");
        int unknownCount = 0;

        var indexBuilder = new StringBuilder();
        for (String word : textAnalytics.getWords()) {
            indexBuilder.append(word);
            if (! dictionary.contains(word)) {
                indexBuilder.append("*");
                unknownCount++;
            }
        }
        return stringBuilder.append("(unknown: ").append(unknownCount).append("):")
                .append(indexBuilder).toString();
    }
}
