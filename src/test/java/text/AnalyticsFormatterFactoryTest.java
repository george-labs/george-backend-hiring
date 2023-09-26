package text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnalyticsFormatterFactoryTest {
    @Test
    public void testCreateSimpleAnalyticsFormatterOnNoIndex() {
        AnalyticsFormatter result = new AnalyticsFormatterFactory().createTextAnalyticsFormatter(null);

        Assertions.assertInstanceOf(SimpleAnalyticsFormatter.class, result);
    }
    @Test
    public void testCreateSimpleAnalyticsFormatterOnInvalidArgs() {
        AnalyticsFormatter result = new AnalyticsFormatterFactory().createTextAnalyticsFormatter(new String[]{"-unrelated stuff"});

        Assertions.assertInstanceOf(SimpleAnalyticsFormatter.class, result);
    }
    @Test
    public void testCreateSimpleAnalyticsFormatterOnIndex() {
        AnalyticsFormatter result = new AnalyticsFormatterFactory().createTextAnalyticsFormatter(new String[]{"-index"});

        Assertions.assertInstanceOf(IndexedAnalyticsDecorator.class, result);
    }
}
