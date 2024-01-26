import org.jetbrains.annotations.NotNull;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

public class PathCheck {

    public Boolean checkNull(String path) {
        return path == null;
    }

    public Boolean pathIsInvalid(@NotNull String path) {
        return !Files.exists(Path.of(path), LinkOption.NOFOLLOW_LINKS);
    }
}
