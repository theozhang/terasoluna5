package com.dhc.uim.app.user;

import java.io.Serializable;

public class UserForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1747314451526962161L;
	private String todoTitle;

	public String getTodoTitle() {
		return todoTitle;
	}

	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}
}
