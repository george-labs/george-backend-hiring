package filter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RegexFilter implements Filter{
	
	public RegexFilter() {
	}

	@Override
	public List<String> filter(List<String> input) {

		if (input == null || input.isEmpty()) {
			Collections.emptyList();
		}
		
		return input.stream()
				.filter(e -> isValidWord(e))
				.collect(Collectors.toList());
	}
	
	private boolean isValidWord(String word) {
		return word.matches("^[a-zA-Z]+$");
	}

}
