import java.util.ArrayList;

public class WordEngine {

    private final InputService inputService = new InputService();
    private final DictionaryService dictionaryService = new DictionaryService("C:\\Users\\Memes\\Desktop\\george-backend-hiring\\src\\main\\resources\\stopwords.txt");

    public void execute(String filename) {
        try {
            String str = inputService.getInput(filename);
            read(str);
        } catch (RuntimeException ex) {
          ex.printStackTrace();
        }
    }

    public int read(String input) {
        ArrayList<String> list = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
               if (isLetter(input.charAt(i))) {
                   stringBuilder.append(input.charAt(i));
               } else {
                   if (stringBuilder.length() != 0 && !dictionaryService.contains(stringBuilder.toString())) {
                       list.add(stringBuilder.toString());
                   }
                       stringBuilder.setLength(0);
               }
        }
        if (stringBuilder.length() != 0 && !dictionaryService.contains(stringBuilder.toString())) { //TODO remove
            list.add(stringBuilder.toString());
        }

        System.out.println(String.format("Number of words: %s", list.size()));
        return list.size();
    }

    //65-90 97-122(toLowercase?)
    public boolean isLetter (int ch) {
        return (ch > 64 && ch < 91) || (ch > 96 && ch < 123);
    }

}
