package text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextAnalyticsFormatterTest {

    @Test
    public void testFormatAnalyticsFormatDecimalPoints() {
        TextAnalytics textAnalytics = new TextAnalytics(7, 6, 6.42323);

        String result = new TextAnalyticsFormatter(textAnalytics).getFormattedData();

        Assertions.assertEquals("Number of words:7, unique: 6, average word length: 6.42 characters", result);
    }

    @Test
    public void testFormatAnalyticsNullInput() {
        String result = new TextAnalyticsFormatter(null).getFormattedData();

        Assertions.assertEquals("", result);
    }
}
