package text;

import input.AppArguments;

public class AnalyticsFormatterFactory {

    public AnalyticsFormatter createTextAnalyticsFormatter(AppArguments appArguments) {
        AnalyticsFormatter analyticsFormatter = new SimpleAnalyticsFormatter();
        if (appArguments.isIndexed()) {
            analyticsFormatter = new IndexedAnalyticsDecorator(analyticsFormatter, appArguments.getDictionary());
        }
        return analyticsFormatter;
    }
}
