package com.master.core.demain.enu;

public enum AppSetting {
	ad_expiry_day;
	public String getLabel() {
		switch (this) {
		case ad_expiry_day: return "ad_expiry_day";
		default: return "";
		}
	}
}
