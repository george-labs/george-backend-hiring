package text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TextAnalyticsFormatterTest {

    @Test
    public void testFormatAnalyticsFormatDecimalPoints() {
        TextAnalytics textAnalytics = new TextAnalytics(7, 6, 6.42323, List.of());

        String result = new TextAnalyticsFormatter(false).getFormattedData(textAnalytics);

        Assertions.assertEquals("Number of words:7, unique: 6, average word length: 6.42 characters", result);
    }

    @Test
    public void testFormatAnalyticsNullInput() {
        String result = new TextAnalyticsFormatter(false).getFormattedData(null);

        Assertions.assertEquals("", result);
    }
}
