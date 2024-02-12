package processor;

import validator.Validator;

import java.util.List;

public class ItemProcessor implements Processor{

    // TODO: removing this field
    private final Validator validator;

    public ItemProcessor(Validator validator) {
        this.validator = validator;
    }

    // TODO: Refactoring to do only the counting at the time
    // TODO: passing some Function<I, O> to this method to be more generic
    @Override
    public long process(List<String> input) {
        return input.stream()
                .count();


    }
}
