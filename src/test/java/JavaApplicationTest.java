import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JavaApplicationTest {

  @Test
  void dummyTest() {
    int actual = 4 + 4;
    int expected = 8;
    Assertions.assertEquals(expected, actual);
  }
}
