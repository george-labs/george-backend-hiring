package com.interview.wordcount.business.port.inner;

import java.util.Collection;

public interface CountWordsUseCase {
	long count(Collection<String> words);
}
