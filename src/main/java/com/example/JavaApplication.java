package com.example;

import com.example.tasks.Task;
import com.example.utils.Utils;

public class JavaApplication {
    public static void main(String ... args) {
        Task task = new Task(args, Utils.readStopWordsFromResources());
        task.readInput();
        task.validate();
        task.process();
    }
}
