package processor;

import validator.Validator;

import java.util.List;

public class ItemProcessor implements Processor{

    private final Validator validator;

    public ItemProcessor(Validator validator) {
        this.validator = validator;
    }

    @Override
    public long process(List<String> input) {
        return input.stream()
                .filter(str -> validator.isValidInput(str))
                .count();


    }
}
