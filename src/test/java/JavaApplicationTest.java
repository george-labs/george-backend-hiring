import cli.ConsoleManager;
import org.junit.jupiter.api.Test;
import processor.StopWordsProvider;
import processor.TextProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaApplicationTest {

    private final List<Integer> EXPECTED_METHOD_CALLS = List.of(0, 1, 2, 3, 4);
    private List<Integer> methodCalls = new ArrayList();

    @Test
    void run_callMethod_ShouldCallMethodsOfDependenciesInCorrectOrder() {
        new JavaApplication(new MockConsoleManager(), new MockStopWordsProvider(), new MockTextProcessor()).run();

        assertEquals(EXPECTED_METHOD_CALLS, methodCalls);
    }

    class MockConsoleManager implements ConsoleManager {

        @Override
        public String printTextPromptAndReadInput() {
            methodCalls.add(1);
            return "";
        }

        @Override
        public void printNumberOfWords(long num) {
            methodCalls.add(4);
        }
    }

    class MockTextProcessor implements TextProcessor {

        @Override
        public long countWords(String text, Set<String> stopWords) {
            methodCalls.add(3);
            return 0;
        }
    }

    class MockStopWordsProvider implements StopWordsProvider {

        @Override
        public void init(String stopWordsResourcePath) {
            methodCalls.add(0);
        }

        @Override
        public Set<String> getStopWords() {
            methodCalls.add(2);
            return Set.of();
        }
    }
}
