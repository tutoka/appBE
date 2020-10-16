package com.appBE.model;

public class Warn {

	private String warn_type;
	private String warn_content;
	private String warn_state;

	// public Warn(long id, String content) {
	// 	this.id = id;
	// 	this.content = content;
	// }

	public Warn(String warn_type, String warn_content, String warn_state) {
		this.warn_type = warn_type;
		this.warn_content = warn_content;
		this.warn_state = warn_state;

	}

	public String getWarnType() {
		return warn_type;
	}

	public String getWarnContent() {
		return warn_content;
	}

	public String getWarnState() {
		return warn_state;
	}
}
