package com.example.tracker.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class User {
	private final Map<String, Task> tasks = new HashMap<>();

	public User(String name) {
	}

	public void createTask(String taskName) {
		tasks.putIfAbsent(taskName, new Task(taskName, TaskState.CREATED));
	}

	public void startTask(String taskName) {
		updateTaskState(taskName, TaskState.STARTED);
	}

	public void stopTask(String taskName) {
		updateTaskState(taskName, TaskState.STOPPED);
	}

	public List<Task> listTasks() {
		return List.copyOf(tasks.values());
	}

	private void updateTaskState(String taskName, TaskState newState) {
		if (!tasks.containsKey(taskName)) {
			throw new NoSuchElementException("Task not found: " + taskName);
		}
		tasks.put(taskName, tasks.get(taskName).changeState(newState));
	}
}
