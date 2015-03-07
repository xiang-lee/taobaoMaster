package com.master.core.event;

public class UpdateEvent {
	private boolean entityFound = true;

	public boolean isEntityFound() {
		return entityFound;
	}

	public void setEntityFound(boolean entityFound) {
		this.entityFound = entityFound;
	}

}
