package george.filter;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UniquenessWordsFilterTest {

  private UniquenessWordsFilter uniquenessWordsFilter = new UniquenessWordsFilter();

  @Test
  void filterAllUniq() {
    List<String> words = uniquenessWordsFilter.filter(List.of("fdf", "qq", "ee"));

    Assertions.assertEquals(3, words.size());
  }

  @Test
  void filterOneUniq() {
    List<String> words = uniquenessWordsFilter.filter(List.of("qq", "qq", "ee", "qq"));

    Assertions.assertEquals(1, words.size());
  }

  @Test
  void filterNoUniq() {
    List<String> words = uniquenessWordsFilter.filter(List.of("qq", "qq", "xx", "xx"));

    Assertions.assertEquals(0, words.size());
  }

  @Test
  void filterThreeUniq() {
    List<String> words = uniquenessWordsFilter.filter(List.of("rrrr", "dfdf", "xx", "xx", "^&%"));

    Assertions.assertEquals(3, words.size());
  }

  @Test
  void filterEmptyList() {
    List<String> words = uniquenessWordsFilter.filter(List.of());

    Assertions.assertEquals(0, words.size());
  }

}