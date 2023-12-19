import java.util.Optional;

public interface ParamParser {
    boolean shouldCreateIndex();

    Optional<String> getFileName();

    Optional<String> getDictionaryFileName();
}
