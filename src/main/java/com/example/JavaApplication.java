package com.example;

import com.example.tasks.Task;
import com.example.tasks.TaskImpl;
import com.example.utils.Utils;

public class JavaApplication {
    public static void main(String ... args) {
        Task task = new TaskImpl(args, Utils.readStopWordsFromResources());
        task.readInput();
        task.validate();
        task.process();
    }
}
