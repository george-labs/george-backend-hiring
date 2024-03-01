public class JavaApplication {
    public static void main(String[] args){
        CountingWords countingWords = new CountingWords();
        String text = ScannerUtil.scanText();
        var count = countingWords.countNumberOfWords(text);
        System.out.println("Number of words: " + count);
    }
}
