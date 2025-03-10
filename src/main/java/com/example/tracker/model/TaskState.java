package com.example.tracker.model;

import java.util.Map;
import java.util.Set;

public enum TaskState {
	CREATED, STARTED, STOPPED;

	private static final Map<TaskState, Set<TaskState>> states = Map.of(
			CREATED, Set.of(STARTED),
			STARTED, Set.of(STOPPED)
	);

	public boolean canChangeState(TaskState newState) {
		return states.getOrDefault(this, Set.of()).contains(newState);
	}
}
