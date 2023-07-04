public class Words implements WordsCounting{

    public String word;

    public Integer count;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int countingWordsOnlyLetter(String words) {

        return 0;
    }
}
