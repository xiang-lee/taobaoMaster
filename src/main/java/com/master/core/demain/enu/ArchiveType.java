package com.master.core.demain.enu;

public enum ArchiveType {
	user,
	admin,
	time,
	unarchive;
	public String getLabel() {
		switch (this) {
		case user: return "user";
		case admin: return "admin";
		case time: return "time";
		default: return "";
		}
	}
}
