package com.master.core.demain.enu;

public enum AdminLevel {
	full;
	public String getRole() {
		switch (this) {
		case full: return "ROLE_ADMIN";
		default: return "";
		}
	}
}
