package filter;

import java.util.List;

public interface FilterService {
	
	List<String> apply(String input);
	
	void registerFilter(Filter filter);

}
