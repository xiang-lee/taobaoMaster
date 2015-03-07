package com.master.core.demain.enu;

public enum EmailTemplateName {
	user_register,
	forget_password,
	ad_published,
	ad_rejected,
	ad_archived;
	public String getLabel() {
		switch (this) {
		case user_register: return "user_register";
		case forget_password: return "forget_password";
		case ad_published: return "ad_published";
		case ad_rejected: return "ad_rejected";
		case ad_archived: return "ad_archived";
		default: return "";
		}
	}
}
