package counter.filter;

public interface StopWordsFilter {
    /**
     * Checks if given is allowed.
     *
     * @param word text to check
     * @return true if given word is allowed
     */
    boolean isAllowed(String word);
}
