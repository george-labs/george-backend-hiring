public interface IWordCounter {

    CountResult countWords(String text);

    void loadExcludedWords(String fileName);

}
