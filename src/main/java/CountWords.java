public class CountWords {

    public int count(String text) {

        int count = 0;
        String[] words = text.split("\\s+");

        for(int i = 0; i < words.length; i++) {
            if(words[i].matches("[a-zA-Z]+")) {
                count++;
            }
        }
        return count;
    }
}
