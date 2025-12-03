package service;

import exception.InvalidInputException;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public void isValid(String inputString) {

        if(inputString.isBlank()) {
            throw new InvalidInputException("The input string is empty");
        }

    }
}
