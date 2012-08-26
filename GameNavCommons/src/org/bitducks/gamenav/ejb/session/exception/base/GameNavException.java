
package org.bitducks.gamenav.ejb.session.exception.base;

import java.util.ArrayList;
import java.util.List;

public class GameNavException extends Exception {

	private static final long	serialVersionUID	= 1L;

	private final List<GameNavError>	errors				= new ArrayList<GameNavError>();

	public GameNavException() {

		super();
	}

	public GameNavException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {

		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GameNavException(String message, Throwable cause) {

		super(message, cause);
	}

	public GameNavException(String message) {

		super(message);
	}

	public GameNavException(Throwable cause) {

		super(cause);
	}

	public GameNavException(GameNavError error) {

		super();
		this.addError(error);
	}

	public void addError(GameNavError error) {

		this.errors.add(error);
	}

	public boolean removeError(GameNavError error) {

		return this.errors.remove(error);
	}

	public List<GameNavError> getErrors() {

		return this.errors;
	}
}
