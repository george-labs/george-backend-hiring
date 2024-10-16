package service;

import input.FileWordsProvider;
import input.InputReader;
import input.WordsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import output.OutputWriter;
import service.mocks.InputReaderMock;
import service.mocks.OutputWriterMock;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputReaderServiceTest {

    private InputReader inputReaderMock;
    private InputReaderService inputReaderService;
    private WordsProvider wordsProvider;
    private OutputWriter outputWriterMock;
    private final String mockConsoleText = "Marry has a little lamb";

    @BeforeEach
    public void setUp() {
        outputWriterMock = new OutputWriterMock();
        wordsProvider = new FileWordsProvider();
    }

    @Test
    public void givenWordsWithoutArgs_whenGetInput_returnWordsAsString() throws IOException {
        inputReaderMock = new InputReaderMock(mockConsoleText);
        inputReaderService = new InputReaderService(wordsProvider, outputWriterMock, inputReaderMock);
        String[] args = null;

        String result = inputReaderService.getInput(args);

        assertEquals(mockConsoleText, result);
    }
}
