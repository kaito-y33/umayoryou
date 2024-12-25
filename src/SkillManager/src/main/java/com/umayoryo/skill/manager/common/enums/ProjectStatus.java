package com.umayoryo.skill.manager.common.enums;

/**
 * プロジェクトのステータス.
 * 
 * @author YOSHIHASHI Kaito
 */
public enum ProjectStatus {

	ACTIVE(1, "稼働中"),
	COMPLETED(2, "稼働完了"),
	CANCELED(3, "稼働中止");

	private final int value;
	private final String viewName;

	private ProjectStatus(int value, String viewName) {

		this.value = value;
		this.viewName = viewName;
	}

	public int getValue() {

		return this.value;
	}

	public String getViewName() {

		return this.viewName;
	}
}
