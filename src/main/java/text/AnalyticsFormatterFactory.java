package text;

import java.util.Arrays;

public class AnalyticsFormatterFactory {

    public AnalyticsFormatter createTextAnalyticsFormatter(String[] args) {
        AnalyticsFormatter analyticsFormatter = new SimpleAnalyticsFormatter();
        if (includeIndex(args)) {
            analyticsFormatter = new IndexedAnalyticsDecorator(analyticsFormatter);
        }
        return analyticsFormatter;
    }

    private boolean includeIndex(String[] args) {
        if (args == null || args.length == 0) {
            return false;
        }
        return Arrays.asList(args).contains("-index");
    }
}
