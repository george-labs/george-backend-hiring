package input;

import java.util.Set;

public class AppArguments {
    private final boolean indexed;
    private final Set<String> dictionary;

    public AppArguments(boolean indexed, Set<String> dictionary) {
        this.indexed = indexed;
        this.dictionary = dictionary;
    }

    public boolean isIndexed() {
        return indexed;
    }

    public Set<String> getDictionary() {
        return dictionary;
    }
}
