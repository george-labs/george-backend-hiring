package application.infrastructure.output;

import static application.infrastructure.InfrastructureConstants.CONSOLE_OUTPUT_TOTAL_COUNT_TEXT;
import static application.infrastructure.InfrastructureConstants.CONSOLE_OUTPUT_UNIQUE_COUNT_TEXT;

class OutputBuilder {

    static String buildOutput(final Long totalCount, final Long uniqCount) {
        return CONSOLE_OUTPUT_TOTAL_COUNT_TEXT + totalCount + ", " +
                CONSOLE_OUTPUT_UNIQUE_COUNT_TEXT + uniqCount;
    }
}
