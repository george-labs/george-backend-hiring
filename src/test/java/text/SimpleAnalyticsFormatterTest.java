package text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SimpleAnalyticsFormatterTest {

    @Test
    public void testFormatAnalyticsFormatDecimalPoints() {
        TextAnalytics textAnalytics = new TextAnalytics(7, 6, 6.42323, List.of());

        String result = new SimpleAnalyticsFormatter().getFormattedData(textAnalytics);

        Assertions.assertEquals("Number of words:7, unique: 6, average word length: 6.42 characters", result);
    }

    @Test
    public void testFormatAnalyticsNullInput() {
        String result = new SimpleAnalyticsFormatter().getFormattedData(null);

        Assertions.assertEquals("", result);
    }
}
