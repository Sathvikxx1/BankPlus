package me.pulsi_.bankplus.managers;

import com.tcoded.folialib.wrapper.task.WrappedTask;

import java.util.HashMap;

public class BPTaskManager {

    public static final String INTEREST_TASK = "interest", MONEY_SAVING_TASK = "money_saving", BANKTOP_BROADCAST_TASK = "banktop_broadcast";

    private static final HashMap<String, WrappedTask> tasks = new HashMap<>();

    public static void setTask(String name, WrappedTask task) {
        String identifier = name.toLowerCase();
        if (tasks.containsKey(identifier)) tasks.get(identifier).cancel();
        tasks.put(identifier, task);
    }

    public static WrappedTask getTask(String name) {
        return tasks.get(name.toLowerCase());
    }

    public static WrappedTask removeTask(String name) {
        return tasks.remove(name.toLowerCase());
    }

    public static boolean contains(String name) {
        return tasks.containsKey(name.toLowerCase());
    }
}