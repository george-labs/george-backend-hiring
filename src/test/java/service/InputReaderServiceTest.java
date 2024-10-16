package service;

import input.InputReader;
import input.WordsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import output.OutputWriter;
import service.mocks.FileWordsProviderMock;
import service.mocks.InputReaderMock;
import service.mocks.OutputWriterMock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputReaderServiceTest {

    private InputReader inputReaderMock;
    private InputReaderService inputReaderService;
    private WordsProvider wordsProvider;
    private OutputWriter outputWriterMock;
    private final String mockConsoleText = "Marry has a little lamb";
    private final List<String> mockFileText = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        outputWriterMock = new OutputWriterMock();
    }

    @Test
    public void givenWordsWithoutArgs_whenGetInput_returnWordsAsString() throws IOException {
        inputReaderMock = new InputReaderMock(mockConsoleText);
        inputReaderService = new InputReaderService(wordsProvider, outputWriterMock, inputReaderMock);
        String[] args = null;

        String result = inputReaderService.getInput(args);

        assertEquals(mockConsoleText, result);
    }

    @Test
    public void givenWordsWithArgs_whenGetInput_returnWordsAsString() throws IOException {
        inputReaderMock = new InputReaderMock(mockConsoleText);
        mockFileText.add("Marry had");
        mockFileText.add("a little");
        mockFileText.add("lamb");

        wordsProvider = new FileWordsProviderMock(mockFileText);
        inputReaderService = new InputReaderService(wordsProvider, outputWriterMock, inputReaderMock);

        String[] args = new String[]{"mytext.txt"};

        String result = inputReaderService.getInput(args);

        String expected = String.join(" ", mockFileText);

        assertEquals(expected, result);
    }

}
