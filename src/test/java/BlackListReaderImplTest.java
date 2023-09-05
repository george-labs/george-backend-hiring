import exception.BlackListException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlackListReaderImplTest {

    @Test
    void should_throw_exception_if_not_found() {
        // prepare data
        final BlackListReader blackListReader = createBlackListReader("some-nonsense.txt");
        final String expectedErrorMessage = "File 'some-nonsense.txt' not found";

        Exception exception = assertThrows(BlackListException.class, () -> {
            blackListReader.getBlackList();
        });

        final String actualExceptionMessage = exception.getMessage();

        assertEquals(expectedErrorMessage, actualExceptionMessage);
    }

    @Test
    void should_read_file_from_resources() {
        // prepare data
        final List<String> expectedBlackList = List.of("aa", "bb");
        final BlackListReader blackListReader = createBlackListReader("blacklist.txt");

        // call the actual black list reader
        final Collection<String> actualBlackList = blackListReader.getBlackList();

        // assert the black list values
        System.out.println("");
    }

    static BlackListReader createBlackListReader(final String blackListFileName) {
        final BlackListReadeConfiguration blackListReadeConfiguration =
                new BlackListReadeConfiguration(blackListFileName);

        return new BlackListReaderImpl(blackListReadeConfiguration);
    }

}
