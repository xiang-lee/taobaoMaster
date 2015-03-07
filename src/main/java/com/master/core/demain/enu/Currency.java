package com.master.core.demain.enu;

public enum Currency {
	euro,
	cny;
	public String getLabel() {
		switch (this) {
		case euro: return "euro";
		case cny: return "cny";
		default: return "euro";
		}
	}
}
