package org.mapthree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testAddTask() {
        TaskList taskList = new TaskList();
        Task task = new Task("task");

        taskList.addTask(task);

        Assertions.assertEquals(1, taskList.size());
        Assertions.assertTrue(taskList.getTask(0).isPresent());
        Assertions.assertEquals(task, taskList.getTask(0).get());
    }

    @Test
    public void testGetTaskWhenIndexOutOfBounds() {
        TaskList taskList = new TaskList();
        Task task = new Task("task");
        taskList.addTask(task);

        Assertions.assertTrue(taskList.getTask(1).isEmpty());
        Assertions.assertTrue(taskList.getTask(-1).isEmpty());
    }

}