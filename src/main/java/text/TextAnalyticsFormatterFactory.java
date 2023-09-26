package text;

import java.util.Arrays;

//Not a real factory
public class TextAnalyticsFormatterFactory {

    public TextAnalyticsFormatter createTextAnalyticsFormatter(String[] args) {
        if (args == null || args.length == 0) {
            return new TextAnalyticsFormatter(false);
        }
        boolean isIndexed = Arrays.asList(args).contains("-index");
        return new TextAnalyticsFormatter(isIndexed);
    }
}
