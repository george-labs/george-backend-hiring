package application.infrastructure.output;

import static application.infrastructure.output.OutputBuilder.buildOutput;

public final class ConsoleOutput implements Output {
    @Override
    public void provideOutput(final Long totalCount, final Long uniqCount) {
        System.out.println(buildOutput(totalCount, uniqCount));
    }
}
