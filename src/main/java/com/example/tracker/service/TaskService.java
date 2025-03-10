package com.example.tracker.service;

import com.example.tracker.model.Task;
import com.example.tracker.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class TaskService {
	private final Map<String, User> users = new HashMap<>();

	public void create(String personName, String taskName) {
		users.computeIfAbsent(personName, User::new).createTask(taskName);
	}

	public void start(String personName, String taskName) {
		getUser(personName).startTask(taskName);
	}

	public void stop(String personName, String taskName) {
		getUser(personName).stopTask(taskName);
	}

	public List<Task> list(String personName) {
		return getUser(personName).listTasks();
	}

	private User getUser(String personName) {
		if (!users.containsKey(personName)) {
			throw new NoSuchElementException("User not found: " + personName);
		}
		return users.get(personName);
	}
}
