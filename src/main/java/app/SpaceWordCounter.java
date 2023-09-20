package app;

public class SpaceWordCounter implements WordCounter {

    @Override
    public int countWords(String inputString) {
        return inputString.split("\\s+")
                .length;
    }

}
