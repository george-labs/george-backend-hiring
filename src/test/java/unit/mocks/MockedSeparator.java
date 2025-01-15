package unit.mocks;

import exception.NullInputException;
import java.util.List;
import separator.Separator;

public class MockedSeparator implements Separator {

  private List<String> mockedSeparatedStrings;

  public void setMockedSeparatedStrings(final List<String> list) {
    this.mockedSeparatedStrings = list;
  }

  @Override
  public List<String> separate(final String input) {
    if (input == null) {
      throw new NullInputException();
    }
    return this.mockedSeparatedStrings;
  }
}
