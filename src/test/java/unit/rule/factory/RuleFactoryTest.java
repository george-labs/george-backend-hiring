package unit.rule.factory;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rule.Rule;
import rule.factory.RuleFactory;
import unit.mocks.MockedFileReader;

class RuleFactoryTest {

  private RuleFactory ruleFactory;
  private MockedFileReader mockedFileReader;

  @BeforeEach
  void beforeEach() {
    this.mockedFileReader = new MockedFileReader();
    this.ruleFactory = new RuleFactory(this.mockedFileReader, "mockedPath");
  }

  @Test
  void testGetWordsToIgnoreRule() {
    final List<String> testWordsToIgnore = List.of("oleg", "interview");
    this.mockedFileReader.setMockedList(testWordsToIgnore);

    final Rule actualWordsToIgnoreRule = this.ruleFactory.getWordsToIgnoreRule();
    testWordsToIgnore.forEach(wordToIgnore -> Assertions.assertFalse(actualWordsToIgnoreRule.validate(wordToIgnore)));
  }
}
