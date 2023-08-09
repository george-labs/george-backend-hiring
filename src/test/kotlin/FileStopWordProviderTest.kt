import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File

class FileStopWordProviderTest {

    private lateinit var fileStopWordProvider: FileStopWordProvider

    @BeforeEach
    fun setUp() {
        fileStopWordProvider = FileStopWordProvider(File("./stopwords.txt"))
    }

    @Test
    fun isBanned() {
        Assertions.assertEquals(true, fileStopWordProvider.isBanned("the"))
        Assertions.assertEquals(false, fileStopWordProvider.isBanned("test"))
    }
}
