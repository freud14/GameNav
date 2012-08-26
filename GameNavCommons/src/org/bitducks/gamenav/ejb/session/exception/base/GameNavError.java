
package org.bitducks.gamenav.ejb.session.exception.base;

public class GameNavError {

	private String	errorCode;

	public GameNavError() {

		this.errorCode = "";
	}

	public GameNavError(String errorCode) {

		this.errorCode = errorCode;
	}

	public String getErrorCode() {

		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {

		this.errorCode = errorCode;
	}

}
