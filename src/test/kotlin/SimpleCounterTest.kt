import counter.SimpleCounter
import dto.CounterResult
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SimpleCounterTest {

    companion object {
        val stopWords = listOf("had", "a")
        val simpleCounter = SimpleCounter(stopWords)
    }

    @Test
    fun simpleCounterHappyPath(){
        Assertions.assertEquals(simpleCounter.count("abc bca"), CounterResult(2, 2))
        Assertions.assertEquals(simpleCounter.count("Mary had a little lamb"), CounterResult(5,5))
        Assertions.assertEquals(simpleCounter.count("Mary had a little lamb b8b"), CounterResult(5,5))
        Assertions.assertEquals(simpleCounter.count("Mary had a little lamb b[b"), CounterResult(5,5))
        Assertions.assertEquals(simpleCounter.count("Mary had a little lamb b[b"), CounterResult(5,5))
    }

    @Test
    fun simpleCounterSpecialChars(){
        Assertions.assertEquals(simpleCounter.count(" "), CounterResult(0, 0))
        Assertions.assertEquals(simpleCounter.count("   "), CounterResult(0, 0))
        Assertions.assertEquals(simpleCounter.count(" ]"), CounterResult(0, 0))
        Assertions.assertEquals(simpleCounter.count("8344"), CounterResult(0, 0))
        Assertions.assertEquals(simpleCounter.count("ab7 8344"), CounterResult(0, 0))
        Assertions.assertEquals(simpleCounter.count("8344 ;'; "), CounterResult(0, 0))
    }

    @Test
    fun simpleCounterWhitespaceChars(){
        Assertions.assertEquals(simpleCounter.count("\n"), CounterResult(0, 0))
        Assertions.assertEquals(simpleCounter.count("bab \n\n abc"), CounterResult(2, 2))
        Assertions.assertEquals(simpleCounter.count("\t bca \t ff"), CounterResult(2, 2))
    }

    @Test
    fun simpleCounterStopWords(){
        Assertions.assertEquals(simpleCounter.count("Mary had a little lamb"), CounterResult(3, 3))
    }

    @Test
    fun simpleCounterUniqueWords(){
        Assertions.assertEquals(simpleCounter.count("Mary Mary had a little lamb"), CounterResult(4, 3))
    }
}
