import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import org.junit.jupiter.api.Test;

class StopWordReaderTest {

  @Test
  public void shouldReadStopWordsFile(){
    StopWordReader stopWordReader = new StopWordReader();

    Set<String> stopWords = stopWordReader.readStopWordFile();

    assertEquals(4, stopWords.size());
  }

}