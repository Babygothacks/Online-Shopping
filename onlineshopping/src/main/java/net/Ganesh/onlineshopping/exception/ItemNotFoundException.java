package net.Ganesh.onlineshopping.exception;

import java.io.Serializable;

public class ItemNotFoundException extends Exception implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public ItemNotFoundException() {
		this.msg = "Product you are looking is not available";
	}

	public ItemNotFoundException(String msg) {
		this.msg = msg;
	}
}
