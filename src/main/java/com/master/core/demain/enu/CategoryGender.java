package com.master.core.demain.enu;

public enum CategoryGender {
	men,
	women,
	both;
	public String getLabel() {
		switch (this) {
		case men: return "men";
		case women: return "women";
		case both: return "both";
		default: return "both";
		}
	}
}
