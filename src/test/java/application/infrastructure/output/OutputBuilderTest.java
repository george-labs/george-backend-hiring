package application.infrastructure.output;

import org.junit.jupiter.api.Test;

import static application.infrastructure.InfrastructureConstants.CONSOLE_OUTPUT_TOTAL_COUNT_TEXT;
import static application.infrastructure.InfrastructureConstants.CONSOLE_OUTPUT_UNIQUE_COUNT_TEXT;
import static application.infrastructure.output.OutputBuilder.buildOutput;
import static org.junit.jupiter.api.Assertions.*;

class OutputBuilderTest {

    @Test
    void buildOutputWithResults() {
        // given
        final String expectedResult = CONSOLE_OUTPUT_TOTAL_COUNT_TEXT + 1L + ", " + CONSOLE_OUTPUT_UNIQUE_COUNT_TEXT + 2L;

        // when
        final String result = buildOutput(1L, 2L);

        // then
        assertEquals(expectedResult, result);
    }
}