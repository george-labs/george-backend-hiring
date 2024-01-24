package rules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class StopWordsRule implements IRule{




    @Override
    public boolean process(String word) {
            return false;
    }

    public Set<String> getStopWords() throws IOException {
        //FIXME: file name should not be hardcoded get it from outside
        BufferedReader reader = new BufferedReader(new FileReader("stopwords.txt"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        // delete the last new line separator
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();

        String content = stringBuilder.toString();

        return null;//FIXME?????
    }
}
