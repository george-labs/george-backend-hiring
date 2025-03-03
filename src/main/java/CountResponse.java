public class CountResponse {

    private int totalCount = 0;

    private int uniqueCount = 0;

    private float averageWordLength = 0;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getUniqueCount() {
        return uniqueCount;
    }

    public void setUniqueCount(int uniqueCount) {
        this.uniqueCount = uniqueCount;
    }

    public float getAverageWordLength() {
        return averageWordLength;
    }

    public void setAverageWordLength(float averageWordLength) {
        this.averageWordLength = averageWordLength;
    }
}
