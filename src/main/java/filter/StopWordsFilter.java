package filter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import helper.FileReaderFromResource;

public class StopWordsFilter implements Filter {
	
	private static final String STOPWORDS_FILENAME = "stopwords.txt";
	
	public StopWordsFilter() {}

	@Override
	public List<String> filter(List<String> input) {
		if (Objects.isNull(input) || input.isEmpty()) {
			return Collections.emptyList();
		}
		
		return filterInputOnStopWords(input);
	}
	
	private  List<String> filterInputOnStopWords(List<String> input) {
		Optional<String> stopWordsAsString = FileReaderFromResource
				.getFileContent(STOPWORDS_FILENAME);
		
		if (stopWordsAsString.isEmpty()) {
			return List.of();
		}
		
		List<String> stopWords = Arrays.asList(stopWordsAsString.get().split(" "));
		
		List<String> filteredInput = input.stream()
				.filter(word -> !stopWords.contains(word)).collect(Collectors.toList());
		return filteredInput;
	}

}
