package gyurix.worldcounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WorldCounterTest {
    @Test
    public void testIteration1NoInput() {
        WorldCounter wc = new WorldCounter();
        NullPointerException exception = assertThrows(NullPointerException.class, wc::doWork);
        assertEquals("Input is null", exception.getMessage());
    }

    @Test
    public void testIteration1InvalidInput() {
        WorldCounter wc = new WorldCounter();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> wc.setInput("0"));
        assertEquals("Invalid input, only a-z, A-Z and spaces are allowed", exception.getMessage());
    }

    @Test
    public void testIteration1NotComplete() {
        WorldCounter wc = new WorldCounter();
        wc.setInput("input");
        IllegalStateException exception = assertThrows(IllegalStateException.class, wc::getResult);
        assertEquals("Result is not complete", exception.getMessage());
    }

    @Test
    public void testIteration1ExampleInput() {
        WorldCounter wc = new WorldCounter();
        wc.setInput("Mary had a little lamb");
        wc.doWork();
        int result = wc.getResult();
        assertEquals(5, result);
    }
}
