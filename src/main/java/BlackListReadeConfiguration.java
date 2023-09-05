
class BlackListReadeConfiguration {

    private final String stopWordsFileName;

    public BlackListReadeConfiguration(String stopWordsFileName) {
        this.stopWordsFileName = stopWordsFileName;
    }

    public String getStopWordsFileName() {
        return stopWordsFileName;
    }

}
