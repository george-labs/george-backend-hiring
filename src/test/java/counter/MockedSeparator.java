package counter;

import java.util.List;
import separator.Separator;

public class MockedSeparator implements Separator {

  private List<String> mockedSeparatedStrings;

  public void setMockedSeparatedStrings(final List<String> list) {
    this.mockedSeparatedStrings = list;
  }

  @Override
  public List<String> separate(String input) {
    return this.mockedSeparatedStrings;
  }
}
