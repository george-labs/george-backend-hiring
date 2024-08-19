package com.geogre.wordcount;

import java.util.List;

public class TestConstants {

    public static final String SEPARATOR = " ";
    public static final List<String> STOP_LIST = List.of("the", "a", "of", "on");

    public static final String TEST_INPUT = "The grey goose walks";
    public static final String TEST_INPUT_MIXED = "Let's GO there !";
    public static final String TEST_INPUT_MIXED_NO_CLEAR_WORDS = "Let's p1ck em!";
    public static final String TEST_INPUT_WITH_STOP_WORDS = "Up to the sky !";

}
