package com.example.utils.predicates;

import java.util.function.Predicate;

public class IsTrailingOrLeadingHyphen implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return s.startsWith("-") || s.endsWith("-");
    }
}
