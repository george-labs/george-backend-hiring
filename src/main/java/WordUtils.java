public class WordUtils {

    private WordUtils() {
    }

    public static String[] splitWordsBySpace(String sentence) {
        return sentence.split("\s+");
    }

    public static int countWords(String[] list) {
       return list.length;
    }
}
