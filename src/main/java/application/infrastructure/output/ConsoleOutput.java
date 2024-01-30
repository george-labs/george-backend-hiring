package application.infrastructure.output;

public final class ConsoleOutput implements Output {
    private final String consoleOutput;

    public ConsoleOutput(final String consoleOutput) {
        this.consoleOutput = consoleOutput;
    }

    @Override
    public void provideOutput(final Long result) {
        System.out.println(consoleOutput + result);
    }
}
