package com.interview.wordcount.business.port.inner;

import java.util.List;

public interface ParseWordsUseCase {

	List<String> parse(String text);
}
