import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FilterServiceHyphen implements IFilterService{

    //TODO: Adhere to DRY, remove duplicate impl
    @NotNull
    public List<String> filterInputString(List<String> userInput) {
        if(userInput == null) {
            throw new IllegalArgumentException("Input String must not be null!");
        }

        String regex = "[a-zA-Z-]+";

        return userInput.stream()
                .filter(n -> !n.trim().isEmpty())
                .filter(n -> n.matches(regex))
                .toList();
    }
}
