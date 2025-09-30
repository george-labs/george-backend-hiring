import cli.ConsoleManager;
import org.junit.jupiter.api.Test;
import processor.TextProcessor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

    public final List<Integer> EXPECTED_METHOD_CALLS = List.of(0, 1, 2);
    private List<Integer> methodCalls = new ArrayList();

    @Test
    void run_callMethod_ShouldCallMethodsOfDependenciesInCorrectOrder() {
        new JavaApplication(new MockConsoleManager(), new MockTextProcessor()).run();

        assertEquals(EXPECTED_METHOD_CALLS, methodCalls);
    }

    class MockConsoleManager implements ConsoleManager {

        @Override
        public String printPromptAndReadInput() {
            methodCalls.add(0);
            return "";
        }

        @Override
        public void printNumberOfWords(long num) {
            methodCalls.add(2);
        }
    }

    class MockTextProcessor implements TextProcessor {

        @Override
        public long countWords(String text) {
            methodCalls.add(1);
            return 0;
        }
    }
}
