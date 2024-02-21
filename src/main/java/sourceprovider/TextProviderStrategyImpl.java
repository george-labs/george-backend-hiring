package sourceprovider;

import java.nio.file.Files;
import java.nio.file.Path;

public class TextProviderStrategyImpl implements TextProviderStrategy {

    @Override
    public TextProvider getProvider(String fileName) {
        TextProvider textProvider;
        if (fileName != null && !fileName.isBlank() && Files.exists(Path.of(fileName))) {
            textProvider = new FileTextProvider(fileName);
        } else {
            textProvider = new ConsoleTextProvider();
        }
        return textProvider;
    }
}
