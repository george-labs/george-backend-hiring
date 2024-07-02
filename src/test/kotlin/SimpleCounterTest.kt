import Counter.SimpleCounter
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SimpleCounterTest {

    companion object {
        val stopWords = listOf("had", "a")
        val simpleCounter = SimpleCounter()
    }

    @Test
    fun simpleCounterHappyPath(){
        Assertions.assertEquals(simpleCounter.count("abc bca"), 2)
        Assertions.assertEquals(simpleCounter.count("Mary had a little lamb"), 5)
        Assertions.assertEquals(simpleCounter.count("Mary had a little lamb b8b"), 5)
        Assertions.assertEquals(simpleCounter.count("Mary had a little lamb b[b"), 5)
        Assertions.assertEquals(simpleCounter.count("Mary had a little lamb b[b"), 5)
    }

    @Test
    fun simpleCounterSpecialChars(){
        Assertions.assertEquals(simpleCounter.count(" "), 0)
        Assertions.assertEquals(simpleCounter.count("   "), 0)
        Assertions.assertEquals(simpleCounter.count(" ]"), 0)
        Assertions.assertEquals(simpleCounter.count("8344"), 0)
        Assertions.assertEquals(simpleCounter.count("ab7 8344"), 0)
        Assertions.assertEquals(simpleCounter.count("8344 ;'; "), 0)
    }

    @Test
    fun simpleCounterWhitespaceChars(){
        Assertions.assertEquals(simpleCounter.count("\n"), 0)
        Assertions.assertEquals(simpleCounter.count("bab \n\n abc"), 2)
        Assertions.assertEquals(simpleCounter.count("\t bca \t ff"), 2)
    }

    @Test
    fun simpleCounterStopWords(){
        var simpleCounter = SimpleCounter(stopWords)
        Assertions.assertEquals(simpleCounter.count("Mary had a little lamb"), 3)
    }

}
