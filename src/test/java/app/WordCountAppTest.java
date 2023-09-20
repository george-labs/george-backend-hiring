package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import app.mocks.*;
import app.validation.InputValidator;

class WordCountAppTest {

    @Test
    void Should_test_wordcount_integration() throws IOException {
        // given
        long wordCountResult = 5;
        InputReaderMock inputReaderMock = new InputReaderMock();
        OutputWriterMock outputWriterMock = new OutputWriterMock();

        WordCountApp wordCountApp = new WordCountApp(
                inputReaderMock,
                outputWriterMock,
                new InputValidator(),
                new WordCounterMock(wordCountResult));

        // when
        wordCountApp.run();

        // then
        assertEquals(wordCountResult, outputWriterMock.getCount());
    }

}
