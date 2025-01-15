package unit.mocks;

import java.util.List;
import reader.FileReader;

public class MockedFileReader implements FileReader {

  private List<String> mockedList;

  public void setMockedList(final List<String> mockedList) {
    this.mockedList = mockedList;
  }

  @Override
  public List<String> read(String pathToFile) {
    return this.mockedList;
  }
}
