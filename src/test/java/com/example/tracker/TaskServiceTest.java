package com.example.tracker;

import com.example.tracker.model.Task;
import com.example.tracker.model.TaskState;
import com.example.tracker.service.TaskService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
	private TaskService service;

	@BeforeEach
	void setUp() {
		service = new TaskService();
	}

	@Test
	void shouldCreateTaskForUser() {
		service.create("Test", "Test1");
		List<Task> tasks = service.list("Test");
		assertEquals(1, tasks.size());
		assertEquals("Test1", tasks.getFirst().name());
		assertEquals(TaskState.CREATED, tasks.getFirst().state());
	}

	@Test
	void shouldStartTaskForUser() {
		service.create("Bob", "Task2");
		service.start("Bob", "Task2");
		List<Task> tasks = service.list("Bob");
		assertEquals(TaskState.STARTED, tasks.getFirst().state());
	}

	@Test
	void shouldStopTaskForUser() {
		service.create("Charlie", "Task3");
		service.start("Charlie", "Task3");
		service.stop("Charlie", "Task3");
		List<Task> tasks = service.list("Charlie");
		assertEquals(TaskState.STOPPED, tasks.getFirst().state());
	}
}