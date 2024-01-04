package com.example.utils.predicates;

import java.util.function.Predicate;

public class IsNotEmpty implements Predicate<String> { // extends IsStopWord???
    @Override
    public boolean test(String word) {
        return !word.isEmpty();
    }
}
