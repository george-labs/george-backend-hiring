package wordcounter;

import org.junit.jupiter.api.BeforeEach;
import wordcounter.reader.ConsoleLineReader;

class ConsoleLineReaderTest {
ConsoleLineReader reader;

@BeforeEach
void setup(){
    reader = new ConsoleLineReader();
}
}