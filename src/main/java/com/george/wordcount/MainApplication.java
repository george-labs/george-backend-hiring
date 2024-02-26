package com.george.wordcount;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        System.out.println(ResultFormatter.getResultString(new ContentReaderFactory().getContentReader(args).getContent()));
    }
}
