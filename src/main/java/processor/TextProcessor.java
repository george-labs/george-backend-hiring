package processor;

import java.util.Set;

public interface TextProcessor {

    long countWords(final String text, final Set<String> stopWords);

}
