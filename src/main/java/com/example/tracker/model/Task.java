package com.example.tracker.model;

public record Task(String name, TaskState state) {
	public Task changeState(TaskState newState) {
		if (!state.canChangeState(newState)) {
			throw new IllegalStateException("Invalid state transition from " + state + " to " + newState);
		}
		return new Task(name, newState);
	}
}
