package text;

public class IndexedAnalyticsDecorator implements AnalyticsFormatter{
    private final AnalyticsFormatter analyticsFormatter;

    public IndexedAnalyticsDecorator(AnalyticsFormatter analyticsFormatter) {
        this.analyticsFormatter = analyticsFormatter;
    }

    @Override
    public String getFormattedData(TextAnalytics textAnalytics) {
        return analyticsFormatter.getFormattedData(textAnalytics)
                + "\nIndex:\n" + String.join("\n", textAnalytics.getWords());
    }
}
