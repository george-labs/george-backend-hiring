import data.ResourceFileReader
import domain.StopWordReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class StopWordReaderTest {


    @Test
    fun `GIVEN a file WHEN readStopWords is called THEN return a list of stop words`() {
        // Given
        val stopWordReader = StopWordReader(fileReader = ResourceFileReader())

        // When
        val result = stopWordReader.getStopWords("/mock.txt")

        // Then
        Assertions.assertEquals(3, result.size)
    }

    @Test
    fun `GIVEN a file with empty lines WHEN readStopWords is called THEN return a list of stop words without empty lines`() {
        // Given
        val stopWordReader = StopWordReader(fileReader = ResourceFileReader())

        // When
        val result = stopWordReader.getStopWords("/mockWithEmptyLines.txt")

        // Then
        Assertions.assertEquals(3, result.size)
    }

    @Test
    fun `GIVEN a file with duplicate stop words WHEN readStopWords is called THEN return a list of stop words without duplicates`() {
        // Given
        val stopWordReader = StopWordReader(fileReader = ResourceFileReader())

        // When
        val result = stopWordReader.getStopWords("/mockWithDuplicates.txt")

        // Then
        Assertions.assertEquals(3, result.size)
    }

}